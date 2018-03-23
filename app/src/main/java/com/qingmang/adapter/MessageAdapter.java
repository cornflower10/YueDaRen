package com.qingmang.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class MessageAdapter extends BaseQuickAdapter<HotMessage.ContentBean, BaseViewHolder> {


    public MessageAdapter(@Nullable List<HotMessage.ContentBean> data) {
        super(R.layout.message_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotMessage.ContentBean item) {
        helper.setText(R.id.tv_des,item.getIntroduce());
        helper.setText(R.id.tv_type,String.valueOf(item.getState()));
        helper.setText(R.id.tv_date,String.valueOf(item.getCreatetime()));
        helper.setText(R.id.tv_place,item.getPlace());
        ImageLoaderUtil.getInstance().showImage(item.getLogo(),(ImageView) helper.getView(R.id.iv),0);
    }


}
