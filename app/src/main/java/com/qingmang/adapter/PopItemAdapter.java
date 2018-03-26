package com.qingmang.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.Popup;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class PopItemAdapter extends BaseQuickAdapter<Popup, BaseViewHolder> {


    public PopItemAdapter(@Nullable List<Popup> data) {
        super(R.layout.pop_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Popup item) {
        helper.setText(R.id.tv,item.getName());
    }


}
