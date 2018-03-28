package com.qingmang.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

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
        code2Color(item.getStep(),(TextView) helper.getView(R.id.tv_wait));

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
    private void code2Color(String code, TextView textView){
        if("wait".equals(code)){

        }else   if("ensure".equals(code)){
            textView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.coner_green));
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.green_58c04e));
        }
        else   if("stage".equals(code)){
            textView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.coner_yellow));
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.orange));
        }
        else   if("complete".equals(code)){
            textView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.coner_red));
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.red_ff2a31));
        }
        else   if("close".equals(code)){
            textView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.coner_red));
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.red_ff2a31));
        }
    }



}
