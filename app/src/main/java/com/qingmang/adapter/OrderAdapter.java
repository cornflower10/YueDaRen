package com.qingmang.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.Order;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class OrderAdapter extends BaseQuickAdapter<Order.ContentBean, BaseViewHolder> {


    public OrderAdapter(@Nullable List<Order.ContentBean> data) {
        super(R.layout.order_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Order.ContentBean item) {


    }


}
