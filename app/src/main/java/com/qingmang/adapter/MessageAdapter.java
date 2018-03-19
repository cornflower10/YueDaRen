package com.qingmang.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.Message;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class MessageAdapter extends BaseQuickAdapter<Message.DataBean.ContentBean, BaseViewHolder> {


    public MessageAdapter(@Nullable List<Message.DataBean.ContentBean> data) {
        super(R.layout.message_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Message.DataBean.ContentBean item) {
        helper.setText(R.id.tv_des,item.getContent());
        helper.setText(R.id.tv_type,item.getState());
        helper.setText(R.id.tv_date,String.valueOf(item.getCreatetime()));
        helper.setText(R.id.tv_place,item.getPlace());
    }


}
