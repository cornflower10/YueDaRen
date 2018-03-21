package com.qingmang.user;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.qingmang.MainActivity;
import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.custom.CheckCodeCountDown;
import com.qingmang.moudle.entity.Register;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter, RegisterView> implements RegisterView<Register> {

    @BindView(R.id.et_name)
    AppCompatEditText etName;
    @BindView(R.id.et_phone)
    AppCompatEditText etPhone;
    @BindView(R.id.et_passwd)
    AppCompatEditText etPasswd;
    @BindView(R.id.et_val)
    AppCompatEditText etVal;
    @BindView(R.id.cd_val)
    CheckCodeCountDown cdVal;
    @BindView(R.id.cb_agreement)
    AppCompatCheckBox cbAgreement;

    @Override
    public String setTitleName() {
        return "注册";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDataSuccess(Register register) {

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new RegisterPresenter();
            }
        });
    }

    @Override
    public void onLoadFinished(Loader<RegisterPresenter> loader, RegisterPresenter data) {
        super.onLoadFinished(loader, data);
//        loadViewHelper.showLoading("");
//        presenter.loadData();
    }

    @OnClick({R.id.cb_agreement, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_agreement:
                break;
            case R.id.bt_register:
                startActivity(MainActivity.class);
                break;
        }
    }
}