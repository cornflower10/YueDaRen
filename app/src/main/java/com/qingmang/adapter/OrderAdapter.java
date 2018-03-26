package com.qingmang.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.baselibrary.utils.AmountUtils;
import com.qingmang.baselibrary.utils.DateUtils;
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
         helper.setText(R.id.tv_no,item.getOrdersno());
        helper.setText(R.id.tv_context,item.getGname());
        helper.setText(R.id.tv_tip_context,item.getLeavemsg());
        helper.setText(R.id.tv_price, AmountUtils.amountFormat((double) (item.getPrice())));
        helper.setText(R.id.tv_status,code2Str(item.getStep()));
        helper.setText(R.id.tv_time, DateUtils.transferLongToDate(item.getCreatetime()));
        if("wait".equals(item.getStep())){
            helper.setVisible(R.id.tv_wait,false);
            helper.setVisible(R.id.tv_cancle,true);
            helper.setVisible(R.id.tv_pay,true);
            helper.setText(R.id.tv_pay,item.getIntroduce());

        }else {
            helper.setVisible(R.id.tv_cancle,false);
            helper.setVisible(R.id.tv_pay,false);
            helper.setVisible(R.id.tv_wait,true);
            helper.setText(R.id.tv_wait,item.getIntroduce());
        }

    }


    private String code2Str(String code){
        if("wait".equals(code)){
            return "预约订单";
        }else   if("ensure".equals(code)){
            return "确认订单";
        }
        else   if("stage".equals(code)){
            return "阶段进行中";
        }
        else   if("complete".equals(code)){
            return "已完成";
        }
        else   if("close".equals(code)){
            return "已关闭";
        }

            return "";

    }


}
