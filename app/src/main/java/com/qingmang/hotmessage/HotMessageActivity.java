package com.qingmang.hotmessage;

import android.os.Bundle;
import android.view.View;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.moudle.entity.HotMessage;

public class HotMessageActivity extends BaseMvpActivity<HotMessagePresenter,HotMessageView> implements HotMessageView{

    @Override
    public String setTitleName() {
        return "热点资讯";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_hot_message2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_message);
    }

    @Override
    public void onHotMessageSuccess(HotMessage hotMessage) {

    }
}
