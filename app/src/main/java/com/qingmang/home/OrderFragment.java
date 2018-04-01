package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.R;
import com.qingmang.adapter.OrderAdapter;
import com.qingmang.adapter.PopItemAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.custom.popwindow.CommonPopupWindow;
import com.qingmang.moudle.entity.Order;
import com.qingmang.moudle.entity.Popup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class OrderFragment extends BaseMvpFragment<OrderPresenter, OrderView>
        implements OrderView<Order> ,OnRefreshListener,OnLoadmoreListener {
    @BindView(R.id.tv_object)
    TextView tvObject;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private OrderAdapter orderAdapter;
    private List<Order.ContentBean> contentBeans = new ArrayList<>();

    private CommonPopupWindow popupWindow;
    private CommonPopupWindow popupWindowStatus;
    private List<Popup> popupObject = new ArrayList<>();
    private List<Popup> popupStatus = new ArrayList<>();
    private List<Order.ContentBean> listAll = new ArrayList<>();

    @Override
    protected View getRootView() {
        return srl;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_order;
    }

    private String typeObject = "all";

    private String typeStatus = "all";

    @Override
    protected void initView() {
        loadViewHelper.showLoading("");
        orderAdapter = new OrderAdapter(contentBeans);
        orderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startProgressDialog();
                mPresenter.cancleOrder(contentBeans.get(position).getId());
            }
        });
        rv.setAdapter(orderAdapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));


        popupObject.add(new Popup("citizen", "市民服务"));
        popupObject.add(new Popup("job", "创业服务"));
        popupObject.add(new Popup("all", "全部对象"));

        popupStatus.add(new Popup("wait", "预约订单"));
        popupStatus.add(new Popup("ensure", "确认订单"));
        popupStatus.add(new Popup("stage", "阶段进行中"));
        popupStatus.add(new Popup("complete", "已完成"));
        popupStatus.add(new Popup("close", "已关闭"));
        popupStatus.add(new Popup("all", "全部支付状态"));
//        srl.setEnableAutoLoadmore(true);
        srl.setEnableLoadmore(true);
        srl.setOnRefreshListener(this);
        srl.setOnLoadmoreListener(this);
        mPresenter.loadData(1, "", "",false);
        tvObject.setText("全部对象");
        tvPay.setText("全部支付状态");

    }

    @Override
    public void onResume() {
        super.onResume();

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


    @OnClick({R.id.tv_object, R.id.tv_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_object:
                showDownPop(tvObject);
                break;
            case R.id.tv_pay:
                showDownStatusPop(tvPay);
                break;
        }
    }

    @Override
    public void onError(String msg) {
        srl.finishRefresh();
        loadViewHelper.restore();
        stopProgressDialog();
    }

    @Override
    public void onDataSuccess(Order order) {
        srl.finishRefresh();
        stopProgressDialog();
        loadViewHelper.restore();
        if (null != order.getContent()) {
            listAll = order.getContent();
            orderAdapter.replaceData(order.getContent());
        }
    }


    @Override
    public void onCancelSuccess() {
        startProgressDialog();
        mPresenter.loadData(1, typeObject, typeObject,false);
    }

    @Override
    public void onLoadMoreSuccess(Order order) {
        srl.finishLoadmore();
      orderAdapter.addData(order.getContent());
    }

    @Override
    public void onLoadMoreFail(String error) {
        srl.finishLoadmore();
        if(page==1)
            return;
        page--;
    }

    @Override
    protected OrderPresenter createPresenter() {
        return new OrderPresenter();
    }

    //向下弹出
    public void showDownPop(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(mContext)
                .setView(R.layout.popup_down)
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                .setAnimationStyle(R.style.AnimDown)
                .setViewOnclickListener(new CommonPopupWindow.ViewInterface() {
                    @Override
                    public void getChildView(View view, int layoutResId) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
                        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                        PopItemAdapter popItemAdapter = new PopItemAdapter(popupObject);
                        recyclerView.setAdapter(popItemAdapter);
                        popItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                if (popupWindow != null) {
                                    popupWindow.dismiss();
                                }
                                typeObject = popupObject.get(position).getKey();
                                startProgressDialog();
                                mPresenter.loadData(1,typeObject,typeStatus,false);
                                tvObject.setText(popupObject.get(position).getName());

                            }
                        });
                    }
                })
                .setOutsideTouchable(true)
                .create();
        popupWindow.showAsDropDown(view);
    }


    //向下弹出
    public void showDownStatusPop(View view) {
        if (popupWindowStatus != null && popupWindowStatus.isShowing()) return;
        popupWindowStatus = new CommonPopupWindow.Builder(mContext)
                .setView(R.layout.popup_down)
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                .setAnimationStyle(R.style.AnimDown)
                .setViewOnclickListener(new CommonPopupWindow.ViewInterface() {
                    @Override
                    public void getChildView(View view, int layoutResId) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
                        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                        PopItemAdapter popItemAdapter = new PopItemAdapter(popupStatus);
                        recyclerView.setAdapter(popItemAdapter);
                        popItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                if (popupWindowStatus != null) {
                                    popupWindowStatus.dismiss();
                                }
                                typeStatus = popupStatus.get(position).getKey();
//                                orderAdapter.replaceData(sortType(typeObject, typeStatus, listAll));
                                tvPay.setText(popupStatus.get(position).getName());
                                startProgressDialog();
                                mPresenter.loadData(1,typeObject,typeStatus,false);

                            }
                        });
                    }
                })
                .setOutsideTouchable(true)
                .create();
        popupWindowStatus.showAsDropDown(view);
    }


    private List<Order.ContentBean> sortType(String type, String status, List<Order.ContentBean> contentBeanList) {
        if ("all".equals(type) && "all".equals(status)) {
            return contentBeanList;
        }
        List<Order.ContentBean> list = new ArrayList<>();
        for (Order.ContentBean data : contentBeanList) {
            if ("all".equals(type)) {
                if (status.equals(data.getStep())) {
                    list.add(data);
                }

            } else if ("all".equals(status)) {
                if (type.equals(data.getGtype())) {
                    list.add(data);
                }
            } else if (type.equals(data.getStep()) && status.equals(data.getGtype())) {
                list.add(data);
            }
        }
        return list;
    }

    private int page = 1;
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        page++;
        mPresenter.loadData(page,typeObject,typeStatus,true);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
       mPresenter.loadData(1,typeObject,typeStatus,false);
    }
}
