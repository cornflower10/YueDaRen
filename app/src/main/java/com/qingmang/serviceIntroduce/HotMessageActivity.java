package com.qingmang.serviceIntroduce;

import android.os.Bundle;
import android.view.View;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;

public class HotMessageActivity extends BaseMvpActivity<HotMessagePresenter,HotMessageView> implements HotMessageView {

    @Override
    public String setTitleName() {
        return null;
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_message);
    }

    @Override
    public void onDataSuccess(Object o) {

    }
}
