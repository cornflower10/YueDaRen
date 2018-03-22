package com.qingmang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.qingmang.R;
import com.qingmang.custom.verticaltablayout.QTabView;
import com.qingmang.custom.verticaltablayout.TabAdapter;
import com.qingmang.moudle.entity.Service;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class VTabAdapter implements TabAdapter {

    List<Service.CatesBean> titles;
    private Context context;
    public VTabAdapter(Context context,List<Service.CatesBean> titles ){
        this.context = context;
        this.titles = titles;
    }


    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public int getBadge(int position) {
        if (position == 5) return position;
        return 0;
    }

    @Override
    public QTabView.TabIcon getIcon(int position) {
        return null;
    }

    @Override
    public QTabView.TabTitle getTitle(int position) {
        return new QTabView.TabTitle.Builder(context)
                .setContent(titles.get(position).getName())
                .setTextColor(ContextCompat.getColor(context, R.color.red_ff2a31), Color.BLACK)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }
}
