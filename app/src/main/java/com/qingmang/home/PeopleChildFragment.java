package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.R;
import com.qingmang.adapter.PeopleChildAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.Service;
import com.qingmang.serviceIntroduce.ServiceIntroduceActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class PeopleChildFragment extends BaseMvpFragment<FindPresenter,FindView>implements FindView<Service> {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.rv)
    RecyclerView rv;
    List<Service.GoodsBean.ContentBean> data = new ArrayList<>();
    private PeopleChildAdapter peopleChildAdapter ;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PeopleChildFragment newInstance(int sectionNumber,int drawableId) {
        PeopleChildFragment fragment = new PeopleChildFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt("drawableId", drawableId);

        fragment.setArguments(args);
        return fragment;
    }

    public PeopleChildFragment() {
    }

    @Override
    protected View getRootView() {
        return null;
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.people_child_fragment;
    }

    @Override
    protected void initView() {
        peopleChildAdapter = new PeopleChildAdapter(data);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(peopleChildAdapter);
        peopleChildAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ServiceIntroduceActivity.startActivity(mContext,data.get(position).getId());
            }
        });
    }



    @Override
    public void onError(String msg) {
        showToast(msg);
    }

    @Override
    public void onDataSuccess(Service service) {
        for (int i = 0; i <service.getGoods().getContent().size() ; i++) {

                if (i % 4 == 0) {
                    service.getGoods().getContent().get(i).setDrawableId(R.drawable.index_gszc);
                } else if (i % 4 == 1) {
                    service.getGoods().getContent().get(i).setDrawableId(R.drawable.index_ppsb);
                } else if (i % 4 == 2) {
                    service.getGoods().getContent().get(i).setDrawableId(R.drawable.index_rlzy);
                } else if (i % 4 == 3) {
                    service.getGoods().getContent().get(i).setDrawableId(R.drawable.index_gxbt);
                }
        }
        peopleChildAdapter.replaceData(service.getGoods().getContent());
    }

    @Override
    protected FindPresenter createPresenter() {
        return new FindPresenter();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        LogManager.i("onFragmentVisibleChange.."+isVisible);
        mPresenter.loadData(getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
