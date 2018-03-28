package com.qingmang.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.baselibrary.utils.LogManager;
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

public class AuthCompanyActivity extends BaseMvpActivity<AuthPresenter, AuthView> implements AuthView<String> {

    @BindView(R.id.et_company_name)
    AppCompatEditText etCompanyName;
    @BindView(R.id.et_company_user_name)
    AppCompatEditText etCompanyUserName;
    @BindView(R.id.iv)
    ImageView iv;
    private File imageFile;

    @Override
    public String setTitleName() {
        return "认证企业用户";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_auth_company;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PhotoPicker.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                String imageUrl = photos.get(0);
                compressWithRx(imageUrl);
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
                        return Luban.with(mContext).get(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(@NonNull File file) throws Exception {
                        stopProgressDialog();
                        imageFile = file;
                        ImageLoaderUtil.getInstance().loadLocalCircleImage(file, iv, R.drawable.icon_my);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        stopProgressDialog();
                        LogManager.e("压缩失败..", throwable);
                    }
                });
    }

    private void chooseImages() {
//        Intent toGallery = new Intent(Intent.ACTION_PICK);
//        toGallery.setType("image/*");
////        toGallery.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(toGallery, REQUEST_GALLERY);
        PhotoPicker.builder()
                .setPhotoCount(1)
                .setShowCamera(true)
                .setShowGif(false)
                .setPreviewEnabled(false)
                .start(AuthCompanyActivity.this, PhotoPicker.REQUEST_CODE);
    }

    @Override
    public void onDataSuccess(String s) {
        stopProgressDialog();
        showToast("提交成功");
        finish();

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public AuthPresenter crate() {
                return new AuthPresenter();
            }
        });
    }


    @OnClick({R.id.rl_choose_photo, R.id.bt_update, R.id.bt_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_choose_photo:
                chooseImages();
                break;
            case R.id.bt_update:
                if(TextUtils.isEmpty(etCompanyName.getText().toString())){

                showToast("请填写公司名称");
                return;
            }
                if(TextUtils.isEmpty(etCompanyUserName.getText().toString())){

                    showToast("请填写公司法人");
                    return;
                }
                if(null==imageFile){

                    showToast("请选择照片");
                    return;
                }
                startProgressDialog();
                presenter.updateInfo(etCompanyName.getText().toString(),
                        etCompanyUserName.getText().toString(),imageFile);
                break;
            case R.id.bt_cancel:
                finish();
                break;
        }
    }

}
