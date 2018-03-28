package com.qingmang.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.Service;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/20.
 */

public class PeopleChildAdapter extends BaseQuickAdapter<Service.GoodsBean.ContentBean, BaseViewHolder> {


    public PeopleChildAdapter(@Nullable List<Service.GoodsBean.ContentBean> data) {
        super(R.layout.service_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Service.GoodsBean.ContentBean item) {
        helper.setText(R.id.tv_name_top,item.getName());
        helper.setText(R.id.tv_name_center,item.getName());
        ImageLoaderUtil.getInstance().showImage(item.getLogo(),
                (ImageView) helper.getView(R.id.iv_bg),0);
    }
}
