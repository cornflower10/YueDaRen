package com.qingmang.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.ServiceObject;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class ServiceObjectAdapter extends BaseQuickAdapter<ServiceObject, BaseViewHolder> {


    public ServiceObjectAdapter(@Nullable List<ServiceObject> data) {
        super(R.layout.service_object_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ServiceObject item) {
        helper.setText(R.id.tv_name,item.getName());
        if(item.isChoose()){
            helper.setBackgroundRes(R.id.tv_name,R.drawable.coner_orange_2);
            helper.setTextColor(R.id.tv_name, ContextCompat.getColor(mContext,R.color.white));
        }else {
            helper.setBackgroundRes(R.id.tv_name,R.drawable.coner_gray_2);
            helper.setTextColor(R.id.tv_name, ContextCompat.getColor(mContext,R.color.text_333333));
        }
    }


}
