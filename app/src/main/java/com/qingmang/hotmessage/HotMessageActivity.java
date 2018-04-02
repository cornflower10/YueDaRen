package com.qingmang.hotmessage;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qingmang.R;
import com.qingmang.adapter.MessageAdapter;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.HotMessage;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HotMessageActivity extends BaseMvpActivity<HotMessagePresenter, HotMessageView>
        implements HotMessageView,OnRefreshListener,OnLoadmoreListener {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private int page=1;
    private MessageAdapter messageAdapter;
    private List<HotMessage.ContentBean> contentBeans =new ArrayList<>();

    @Override
    public String setTitleName() {
        return "热点资讯";
    }

    @Override
    public View getRootView() {
        return srl;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_hot_message2;
    }



    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new HotMessagePresenter();
            }
        });
    }
    @Override
    public void onLoadFinished(Loader<HotMessagePresenter> loader, HotMessagePresenter data) {
        super.onLoadFinished(loader, data);
        loadViewHelper.showLoading("");
        srl.setOnRefreshListener(this);
        srl.setOnLoadmoreListener(this);
        srl.setEnableLoadmore(true);
        presenter.loadHotMessage(page,false);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        messageAdapter = new MessageAdapter(contentBeans);
        rv.setAdapter(messageAdapter);
    }

    @Override
    public void onHotMessageSuccess(HotMessage hotMessage) {
        srl.finishRefresh();
        loadViewHelper.restore();
        messageAdapter.replaceData(hotMessage.getContent());
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);
        srl.finishRefresh();
        loadViewHelper.restore();
    }

    @Override
    public void onLoadMoreSuccess(HotMessage hotMessage) {
        srl.finishLoadmore();
        messageAdapter.addData(hotMessage.getContent());
    }

    @Override
    public void onLoadMoreFail(String error) {
        srl.finishLoadmore();
         if(page==1)return;
         page--;
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        page++;
        presenter.loadHotMessage(page,true);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page=1;
        presenter.loadHotMessage(page,false);

    }
}
