package com.qingmang.user;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

import com.qingmang.MainActivity;
import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.baselibrary.utils.ValUtils;
import com.qingmang.custom.CheckCodeCountDown;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter, RegisterView> implements RegisterView<String> {

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
        initListener();
    }

    @Override
    public void onDataSuccess(String sms) {
           stopProgressDialog();
    }

    @Override
    public void onRegister(String o) {
        stopProgressDialog();
        SharedPreferences sharedPreferences = getSharedPreferences("token",MODE_PRIVATE);
        sharedPreferences.edit().putString("token",o).commit();
        startActivity(MainActivity.class);
        finish();
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
    }

    @OnClick({R.id.cb_agreement, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_agreement:
                break;
            case R.id.bt_register:
                if(TextUtils.isEmpty(etName.getText().toString())){
                    showToast("请填写用户名！");
                    return;
                }
                if(TextUtils.isEmpty(etPhone.getText().toString())){
                    showToast("请填写手机号码！");
                    return;
                }
                if(TextUtils.isEmpty(etPasswd.getText().toString())){
                    showToast("请填写密码！");
                    return;
                }
                if(TextUtils.isEmpty(etVal.getText().toString())){
                    showToast("请填写验证码！");
                    return;
                }
                if(!ValUtils.isMobileNO(etPhone.getText().toString())){
                    showToast("手机号码格式不正确！");
                    return;
                }
                if(!ValUtils.isPassword(etPasswd.getText().toString())){
                    showToast("密码不正确！");
                    return;
                }
                startProgressDialog();
                presenter.register(etName.getText().toString(),
                        etPhone.getText().toString(),
                        etPasswd.getText().toString(),
                        etVal.getText().toString());

                break;
        }
    }

    private void initListener() {
        cdVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 必须调用 , 输入框中输入的是手机号 true , 否则 false ,这么做是为了防止不是手机号也进入倒计时
                if(TextUtils.isEmpty(etPhone.getText().toString())){
                    showToast("请填写手机号码！");
                    return;
                }

                boolean phoneNumber = ValUtils.isMobileNO(etPhone.getText().toString());
                cdVal.performOnClick(phoneNumber);
            }
        });
        cdVal.setOnSendCheckCodeListener(new CheckCodeCountDown.OnSendCheckCodeListener() {
            @Override
            public void sendCheckCode() {
//                TODO 向手机发送验证码的逻辑
                startProgressDialog();
                presenter.sendSms(etPhone.getText().toString());
            }
        });
        cdVal.setOnFinishListener(new CheckCodeCountDown.OnFinishListener() {
            @Override
            public void OnFinish() {
//              TODO 计时结束后的操作
                cdVal.setText("重新发送");
            }
        });
    }

}
