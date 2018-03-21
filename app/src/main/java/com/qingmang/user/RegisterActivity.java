package com.qingmang.user;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.Register;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter,RegisterView> implements RegisterView<Register> {

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
}
