package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.R;
import com.qingmang.adapter.UtilBoxAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.CustomerInfo;
import com.qingmang.moudle.entity.UtilBox;
import com.qingmang.user.AuthCompanyActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class MyFragment extends BaseMvpFragment<MyPresenter, MyView> implements MyView<CustomerInfo> {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_yhj)
    TextView tvYhj;
    @BindView(R.id.tv_dzf)
    TextView tvDzf;
    private UtilBoxAdapter utilBoxAdapter;
    private List<UtilBox> utilBoxes = new ArrayList<>();

    @Override
    protected View getRootView() {
        return null;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        LogManager.i("MyFragment-----");

        utilBoxes.add(new UtilBox(1, "人才模拟试题", R.drawable.icon_my_mnst));
        utilBoxes.add(new UtilBox(2, "社保查询", R.drawable.icon_my_sbcx));
        utilBoxes.add(new UtilBox(3, "入学积分查询", R.drawable.icon_my_rxjf));
        utilBoxes.add(new UtilBox(4, "购房贷款", R.drawable.icon_my_gfdk));
        utilBoxes.add(new UtilBox(5, "购车贷款", R.drawable.icon_my_gcdk));

        utilBoxAdapter = new UtilBoxAdapter(utilBoxes);
        rv.setAdapter(utilBoxAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        rv.setLayoutManager(layoutManager);
        utilBoxAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("正在维护中...");
            }
        });
        mPresenter.loadData();
    }

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("MyFragment-----" + isVisible);
    }

    @Override
    public void onError(String msg) {
        showToast(msg);
    }

    @Override
    public void onDataSuccess(CustomerInfo customerInfo) {
        tvName.setText(customerInfo.getName());
        tvAmount.setText(String.valueOf(customerInfo.getScore()));
        tvYhj.setText(String.valueOf(customerInfo.getCouponum()));
        tvDzf.setText(String.valueOf(customerInfo.getOrdersnum()));


    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }


    @OnClick({R.id.iv_setting, R.id.ll_rzqy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
//                startActivity();
                break;
            case R.id.ll_rzqy:
                startActivity(AuthCompanyActivity.class);
                break;
        }
    }
}
