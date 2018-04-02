package com.qingmang.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.base.Constans;
import com.qingmang.moudle.entity.VenService;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class VentureServiceAdapter extends BaseQuickAdapter<VenService.ContentBean, BaseViewHolder> {


    public VentureServiceAdapter(@Nullable List<VenService.ContentBean> data) {
        super(R.layout.venture_service_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VenService.ContentBean item) {
        helper.setText(R.id.tv_title,item.getName());
        helper.setText(R.id.tv_des,item.getPoster());
            helper.setBackgroundRes(R.id.tv_type,item.getTypeColor()) ;
        ImageLoaderUtil.getInstance().showImage(Constans.DRAWABLE_URL+item.getDrawableId(),(ImageView) helper.getView(R.id.iv),0);

    }


}
