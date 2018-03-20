package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.R;
import com.qingmang.adapter.VentureServiceAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.VenService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class VentureServiceFragment extends BaseMvpFragment<VentureServicePresenter, VentureServeceView>
        implements VentureServeceView<VenService> {

    @BindView(R.id.rv)
    RecyclerView rv;
    private VentureServiceAdapter ventureServiceAdapter;
    private List<VenService.ContentBean> list = new ArrayList<>();

    @Override
    protected View getRootView() {
        return rv;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_venture_service;
    }

    @Override
    protected void initView() {
        LogManager.i("MyFragment-----");
        loadViewHelper.showLoading("加载中");
        mPresenter.loadData();
        ventureServiceAdapter = new VentureServiceAdapter(list);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(ventureServiceAdapter);
        ventureServiceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    public static VentureServiceFragment newInstance() {

        Bundle args = new Bundle();

        VentureServiceFragment fragment = new VentureServiceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("VentureServiceFragment-----" + isVisible);
    }

    @Override
    public void onError(String msg) {
        showToast(msg);
    }

    @Override
    public void onDataSuccess(VenService venService) {
        List<VenService.ContentBean> contentBeans
                =  venService.getContent();
        loadViewHelper.restore();
        if(null!=contentBeans &&contentBeans.size()>0){
            ventureServiceAdapter.replaceData(contentBeans);
        }

    }

    @Override
    protected VentureServicePresenter createPresenter() {
        return new VentureServicePresenter();
    }

}
