package com.qingmang.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.baselibrary.utils.ValUtils;
import com.qingmang.moudle.entity.CustomerInfo;
import com.qingmang.serviceIntroduce.AddressListActivity;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.iwf.photopicker.PhotoPicker;
import top.zibin.luban.Luban;

public class SettingActivity extends BaseMvpActivity<SettingPresenter, SettingView> implements SettingView<String> {

    @BindView(R.id.et_user_name)
    TextView etUserName;
    @BindView(R.id.tv_name)
    AppCompatEditText tvName;
    @BindView(R.id.tv_always_address)
    TextView tvAlwaysAddress;
    @BindView(R.id.tv_place)
    TextView tvPlace;
    @BindView(R.id.tv_place_detail)
    AppCompatEditText tvPlaceDetail;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.et_real_name)
    AppCompatEditText etRealName;
    @BindView(R.id.et_email)
    AppCompatEditText etEmail;
    @BindView(R.id.et_id_card)
    AppCompatEditText etIdCard;
    @BindView(R.id.iv_header)
    ImageView ivHeader;
    private CustomerInfo customerInfo;

    private static final int REQUEST_GALLERY = 123;
    private File imageFile;

    @Override
    public String setTitleName() {
        return "基础信息认证";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_setting);
        customerInfo = (CustomerInfo) getIntent().getSerializableExtra("customerInfo");
        if (null != customerInfo) {
            ImageLoaderUtil.getInstance().loadCircleImage(customerInfo.getAvatar(),ivHeader,R.drawable.icon_my);
            etUserName.setText(customerInfo.getName());
            tvPhone.setText(customerInfo.getMobile());
            if(!TextUtils.isEmpty(customerInfo.getProvince()))
            tvPlace.setText(customerInfo.getProvince()+","+customerInfo.getCity()+","+customerInfo.getDistrict());
            tvPlaceDetail.setText(customerInfo.getAddress());
            tvPhone.setText(customerInfo.getMobile());
            etIdCard.setText(customerInfo.getIdcard());
            etRealName.setText(customerInfo.getRealname());
            etEmail.setText(customerInfo.getEmail());
        }
    }

    @Override
    public void onDataSuccess(String s) {
         showToast("修改成功");
         finish();
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new SettingPresenter();
            }
        });
    }

    @OnClick({R.id.tv_always_address, R.id.tv_place, R.id.tv_update_passwd, R.id.bt_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_always_address:
                startActivity(AddressListActivity.class);
                break;
            case R.id.tv_place:
                break;
            case R.id.tv_update_passwd:
                break;
            case R.id.bt_commit:

                String idCard = etIdCard.getText().toString();
                if(!TextUtils.isEmpty(idCard)){
                    if(!ValUtils.isIdNo(idCard)){
                        showToast("身份证格式有误！");
                        return;
                    }
                }
                String email = etEmail.getText().toString();
                if(!TextUtils.isEmpty(email)){
                    if(!ValUtils.isMailbox(email)){
                        showToast("邮箱格式有误！");
                        return;
                    }
                }
                String place = tvPlace.getText().toString();
                String province = null, city=null ,areas=null;
                if(!TextUtils.isEmpty(place)){
                    String [] strs=   place.split(",");
                    province = strs[0];
                    city = strs[1];
                    areas = strs[2];
                }

                startProgressDialog();
                presenter.updateInfo(etUserName.getText().toString(),
                        imageFile,province,city,areas,tvPlaceDetail.getText().toString(),
                        etRealName.getText().toString(),idCard);
                break;
        }
    }

    private void ChooseImages() {
//        Intent toGallery = new Intent(Intent.ACTION_PICK);
//        toGallery.setType("image/*");
////        toGallery.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(toGallery, REQUEST_GALLERY);
        PhotoPicker.builder()
                .setPhotoCount(1)
                .setShowCamera(true)
                .setShowGif(false)
                .setPreviewEnabled(false)
                .start(SettingActivity.this, PhotoPicker.REQUEST_CODE);
    }
    @OnClick(R.id.iv_header)
    public void onViewClicked() {
        ChooseImages();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_GALLERY){
            if(resultCode==RESULT_OK){

                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);

               String imageUrl = photos.get(0);

                //        compressWithLs(photos);
                compressWithRx(imageUrl);
//                imageUrl = ChooseImageUtils.getUriPath(data.getData(),mContext);
//                if(null==imageUrl)
//                    return;
//                ImageLoaderUtil.getInstance().loadLocalCircleImage(imageUrl,ivHeader,R.drawable.icon_my);
//                Bitmap bd = ivHeader.getDrawingCache();
            }

        }

    }

    private void compressWithRx(final String photo) {
        startProgressDialog();
        Flowable.just(photo)
                .observeOn(Schedulers.io())
                .map(new Function<String, File>() {
                    @Override
                    public File apply(String s) throws Exception {
                        return Luban.with(SettingActivity.this).get(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(@NonNull File file) throws Exception {
                        stopProgressDialog();
                        imageFile = file;
                      ImageLoaderUtil.getInstance().loadLocalCircleImage(file,ivHeader,R.drawable.icon_my);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        stopProgressDialog();
                        LogManager.e("压缩失败..",throwable);
                    }
                });
    }



}
