package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qingmang.R;
import com.qingmang.adapter.OrderAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class OrderFragment extends BaseMvpFragment<OrderPresenter,OrderView> implements OrderView<Order> {
    @BindView(R.id.tv_object)
    TextView tvObject;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.rv)
    RecyclerView rv;
    private OrderAdapter orderAdapter;
    private List<Order.ContentBean> contentBeans = new ArrayList<>();

    @Override
    protected View getRootView() {
        return rv;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {
        loadViewHelper.showLoading("");
        orderAdapter = new OrderAdapter(contentBeans);
        rv.setAdapter(orderAdapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.loadData(1,"","");

    }

    public static OrderFragment newInstance() {

        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("OrderFragment-----" + isVisible);
    }


    @OnClick({R.id.tv_object, R.id.tv_pay, R.id.tv_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_object:
                break;
            case R.id.tv_pay:
                break;
            case R.id.tv_service:
                break;
        }
    }

    @Override
    public void onError(String msg) {
        showToast(msg);
        loadViewHelper.restore();
    }

    @Override
    public void onDataSuccess(Order order) {
        if(null!=order.getContent() &&order.getContent().size()>0){
            loadViewHelper.restore();
            orderAdapter.replaceData(order.getContent());
        }
    }

    @Override
    protected OrderPresenter createPresenter() {
        return new OrderPresenter();
    }
}
