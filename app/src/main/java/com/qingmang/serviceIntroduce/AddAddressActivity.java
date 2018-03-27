package com.qingmang.serviceIntroduce;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.baselibrary.utils.ValUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class AddAddressActivity extends BaseMvpActivity<AddAddressPresenter, AddAddressView> implements AddAddressView<String> {

    @BindView(R.id.et_name)
    AppCompatEditText etName;
    @BindView(R.id.et_phone)
    AppCompatEditText etPhone;
    @BindView(R.id.tv_place_city)
    TextView tvPlaceCity;
    @BindView(R.id.tv_place_detail)
    AppCompatEditText tvPlaceDetail;
    CityPickerView mCityPickerView = new CityPickerView();

    @Override
    public String setTitleName() {
        return "新增收货地址";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_add_address;
    }


    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new AddAddressPresenter();
            }
        });
    }

    @Override
    public void onLoadFinished(Loader<AddAddressPresenter> loader, AddAddressPresenter data) {
        super.onLoadFinished(loader, data);
        mCityPickerView.init(mContext);
        initWheel();
    }

    @Override
    public void onError(String msg) {
        stopProgressDialog();
        showToast(msg);
    }

    @Override
    public void onDataSuccess(String s) {
        stopProgressDialog();
        setResult(RESULT_OK);
        finish();

    }


    @OnClick(R.id.bt_add_address)
    public void onViewClicked() {
        startProgressDialog();
        String[] str = tvPlaceCity.getText().toString().split(",");
        String pri = str[0], city = str[1], palce = str[2];
        presenter.addAddress(etName.getText().toString(),
                etPhone.getText().toString(), pri, city, palce,
                tvPlaceDetail.getText().toString());
    }

    /**
     * 弹出选择器
     */
    private void initWheel() {

        CityConfig cityConfig = new CityConfig.Builder().title("选择城市")//标题
                .build();

        mCityPickerView.setConfig(cityConfig);
        mCityPickerView.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                StringBuilder sb = new StringBuilder();
                if (province != null) {
                    sb.append(province.getName() + ",");
                }

                if (city != null) {
                    sb.append(city.getName() + ",");
                }

                if (district != null) {
                    sb.append(district.getName());
                }

                tvPlaceCity.setText("" + sb.toString());

            }

            @Override
            public void onCancel() {
//                ToastUtils.showLongToast(CitypickerWheelActivity.this, "已取消");
            }
        });

    }


    @OnClick({R.id.tv_place_city, R.id.bt_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_place_city:
                mCityPickerView.showCityPicker();
                break;
            case R.id.bt_add_address:
                if(TextUtils.isEmpty(etName.getText().toString())){
                    showToast("请输入收货人！");
                    return;
                }
                if(TextUtils.isEmpty(etPhone.getText().toString())){
                    showToast("请输入手机号码！");
                    return;
                }
                if(ValUtils.isMobileNO(etPhone.getText().toString())){
                    showToast("手机号码格式有误！");
                    return;
                }
                if(tvPlaceCity.getText().toString().equals("请选择省市区街道")){
                    showToast("请选择省市区街道!");
                    return;
                }
                if(TextUtils.isEmpty(tvPlaceDetail.getText().toString())){
                    showToast("请填写详细地址!");
                    return;
                }
                startProgressDialog();
                String[] str = tvPlaceCity.getText().toString().split(",");
                String pri = str[0], city = str[1], palce = str[2];
                presenter.addAddress(etName.getText().toString(),
                        etPhone.getText().toString(), pri, city, palce,
                        tvPlaceDetail.getText().toString());
                break;
        }
    }
}
