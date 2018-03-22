package com.qingmang.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.qingmang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_phone)
    AppCompatEditText etPhone;
    @BindView(R.id.et_passwd)
    AppCompatEditText etPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_login, R.id.tv_forget_passwd, R.id.tv_register, R.id.iv_wei_chat, R.id.iv_qq, R.id.iv_blog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                break;
            case R.id.tv_forget_passwd:
                break;
            case R.id.tv_register:
                break;
            case R.id.iv_wei_chat:
                break;
            case R.id.iv_qq:
                break;
            case R.id.iv_blog:
                break;
        }
    }
}
