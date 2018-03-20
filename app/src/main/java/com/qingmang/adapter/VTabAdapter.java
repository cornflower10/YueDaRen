package com.qingmang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.qingmang.R;
import com.qingmang.custom.verticaltablayout.QTabView;
import com.qingmang.custom.verticaltablayout.TabAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class VTabAdapter implements TabAdapter {

    List<String> titles;
    private Context context;
    public VTabAdapter(Context context){
        this.context = context;
    }

    {
        titles = new ArrayList<>();
        Collections.addAll(titles, "精品推荐", "公司注册", "代理记账",
                "税务服务", "公司变更", "著作权", "法律服务", "商标注册", "营销工具", "人事社保", "差旅服务"
        );
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
                .setContent(titles.get(position))
                .setTextColor(ContextCompat.getColor(context, R.color.red_ff2a31), Color.BLACK)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }
}
