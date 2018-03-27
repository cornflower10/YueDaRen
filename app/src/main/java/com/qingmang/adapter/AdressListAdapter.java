package com.qingmang.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qingmang.R;
import com.qingmang.moudle.entity.Adress;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/9.
 */

public class AdressListAdapter extends BaseQuickAdapter<Adress, BaseViewHolder> {


    public AdressListAdapter(@Nullable List<Adress> data) {
        super(R.layout.adress_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Adress item) {
        helper.setText(R.id.tv_user,item.getCollector());
        helper.setText(R.id.tv_phone,item.getMobile());
        helper.setText(R.id.tv_address_top,item.getProvince()+","+
                item.getCity()+","+item.getAreas()+","+item.getAddress());
        AppCompatCheckBox compatCheckBox = helper.getView(R.id.cb_defult);
        if(item.getTop()==1){
            compatCheckBox.setChecked(true);
        }else {
            compatCheckBox.setChecked(false);
        }
        helper.addOnClickListener(R.id.tv_edit);
        helper.addOnClickListener(R.id.tv_delete);
//        helper.setText(R.id.tv_date,String.valueOf(item.getCreatetime()));
//        helper.setText(R.id.tv_place,item.getPlace());
    }


}
