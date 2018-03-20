package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.BaseFragment;
import com.qingmang.R;
import com.qingmang.adapter.UtilBoxAdapter;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.UtilBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    private UtilBoxAdapter utilBoxAdapter;
    private List<UtilBox> utilBoxes = new ArrayList<>();

    @Override
    protected View getRootView() {
        return null;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        LogManager.i("MyFragment-----");

        utilBoxes.add(new UtilBox(1,"人才模拟试题",R.drawable.icon_my_mnst));
        utilBoxes.add(new UtilBox(2,"社保查询",R.drawable.icon_my_sbcx));
        utilBoxes.add(new UtilBox(3,"入学积分查询",R.drawable.icon_my_rxjf));
        utilBoxes.add(new UtilBox(4,"购房贷款",R.drawable.icon_my_gfdk));
        utilBoxes.add(new UtilBox(5,"购车贷款",R.drawable.icon_my_gcdk));

        utilBoxAdapter= new UtilBoxAdapter(utilBoxes);
        rv.setAdapter(utilBoxAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        rv.setLayoutManager(layoutManager);
        utilBoxAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("MyFragment-----" + isVisible);
    }

}
