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
    @BindView(R.id.rv)
    RecyclerView rv;
    private OrderAdapter orderAdapter;
    private List<Order.ContentBean> contentBeans = new ArrayList<>();

    private CommonPopupWindow popupWindow;
    private CommonPopupWindow popupWindowStatus;
    private List<Popup> popupObject = new ArrayList<>();
    private List<Popup> popupStatus = new ArrayList<>();
    private List<Order.ContentBean> listAll = new ArrayList<>();

    @Override
    protected View getRootView() {
        return rv;
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
        rv.setAdapter(orderAdapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.loadData(1,"","");

        popupObject.add(new Popup("citizen","市民服务"));
        popupObject.add(new Popup("job","创业服务"));
        popupObject.add(new Popup("all","全部对象"));

        popupStatus.add(new Popup("wait","预约订单"));
        popupStatus.add(new Popup("ensure","确认订单"));
        popupStatus.add(new Popup("stage","阶段进行中"));
        popupStatus.add(new Popup("complete","已完成"));
        popupStatus.add(new Popup("close","已关闭"));
        popupStatus.add(new Popup("all","全部支付状态"));

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
        showToast(msg);
        loadViewHelper.restore();
    }

    @Override
    public void onDataSuccess(Order order) {
        if(null!=order.getContent() &&order.getContent().size()>0){
            listAll = order.getContent();
            loadViewHelper.restore();
            orderAdapter.replaceData(order.getContent());
        }
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
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
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
                                typeObject = popupObject.get(position).getKey();
                                orderAdapter.replaceData(sortType(typeObject,typeStatus,listAll));
                                tvObject.setText(popupObject.get(position).getName());
                                if (popupWindow != null) {
                                    popupWindow.dismiss();
                                }
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
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
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
                                typeStatus = popupStatus.get(position).getKey();
                                orderAdapter.replaceData(sortType(typeObject,typeStatus,listAll));
                                tvPay.setText(popupStatus.get(position).getName());
                                if (popupWindowStatus != null) {
                                    popupWindowStatus.dismiss();
                                }
                            }
                        });
                    }
                })
                .setOutsideTouchable(true)
                .create();
        popupWindowStatus.showAsDropDown(view);
    }


    private List<Order.ContentBean> sortType(String type,String status, List<Order.ContentBean> contentBeanList){
        if("all".equals(type)&& "all".equals(status)){
           return contentBeanList;
        }
        List<Order.ContentBean> list = new ArrayList<>();
        for (Order.ContentBean data:contentBeanList) {
            if("all".equals(type)){
                if(status.equals(data.getStep())){
                    list.add(data);
                }

            }else if("all".equals(status)){
                if(type.equals(data.getGtype())){
                    list.add(data);
                }
            }else if(type.equals(data.getStep())&&status.equals(data.getGtype())){
                    list.add(data);
                }
            }
            return list;
    }

}
