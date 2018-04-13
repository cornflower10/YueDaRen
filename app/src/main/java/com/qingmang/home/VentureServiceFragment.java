package com.qingmang.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.R;
import com.qingmang.WebActivity;
import com.qingmang.adapter.VentureServiceAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.VenService;
import com.qingmang.serviceIntroduce.ServiceIntroduceActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yyydjk.library.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class VentureServiceFragment extends BaseMvpFragment<VentureServicePresenter, VentureServeceView>
        implements VentureServeceView<VenService> ,OnRefreshListener,OnLoadmoreListener {

    @BindView(R.id.rv)
    RecyclerView rv;
   private BannerLayout iv;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private int page =1;

    private VentureServiceAdapter ventureServiceAdapter;
    private List<VenService.ContentBean> list = new ArrayList<>();
    List<Banner.ContentBean> listMindBanner = new ArrayList<>();

    @Override
    protected View getRootView() {
        return rv;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_venture_service;
    }

    @Override
    protected void initView() {
        LogManager.i("MyFragment-----");
        loadViewHelper.showLoading("加载中");
        mPresenter.loadMindBanner();
        mPresenter.loadData(page,false);
        ventureServiceAdapter = new VentureServiceAdapter(list);
       View view = LayoutInflater.from(mContext).inflate(R.layout.venture_service_header,null);
        iv = (BannerLayout) view.findViewById(R.id.iv);
        ventureServiceAdapter.addHeaderView(view);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(ventureServiceAdapter);
        ventureServiceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ServiceIntroduceActivity.class);
                intent.putExtra("id", list.get(position).getId());
                startActivity(intent);
            }
        });
        srl.setOnLoadmoreListener(this);
        srl.setOnRefreshListener(this);
        srl.setEnableLoadmore(true);
    }

    public static VentureServiceFragment newInstance() {

        Bundle args = new Bundle();

        VentureServiceFragment fragment = new VentureServiceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("VentureServiceFragment-----" + isVisible);
    }

    @Override
    public void onError(String msg) {
        showToast(msg);
        loadViewHelper.restore();
        srl.finishRefresh();
    }

    @Override
    public void onDataSuccess(VenService venService) {
        loadViewHelper.restore();
        srl.finishRefresh();
        List<VenService.ContentBean> contentBeans
                = venService.getContent();
        loadViewHelper.restore();
        if (null != contentBeans) {
            ventureServiceAdapter.replaceData(formatData(contentBeans));
        }

    }

    @Override
    public void onBannerSuccess(Banner banner) {
        listMindBanner = banner.getContent();
        if (null == listMindBanner)
            return;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < listMindBanner.size(); i++) {
//            if (i % 4 == 0) {
//                list.add(Constans.DRAWABLE_URL + R.drawable.entrep_gszc);
//            } else if (i % 4 == 1) {
//                list.add(Constans.DRAWABLE_URL + R.drawable.entrep_dljz);
//            } else if (i % 4 == 2) {
//                list.add(Constans.DRAWABLE_URL + R.drawable.entrep_zzq);
//            } else if (i % 4 == 3) {
//                list.add(Constans.DRAWABLE_URL + R.drawable.entrep_flfw);
//            }
            list.add(listMindBanner.get(i).getLogo());
        }
        iv.setViewUrls(list);
        iv.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int i) {
                WebActivity.startWebViewActivity(mContext,listMindBanner.get(i).getTitle(),String.valueOf(listMindBanner.get(i).getId()));

            }
        });

    }

    @Override
    public void onLoadMoreSuccess(VenService venService) {
        srl.finishLoadmore();
        ventureServiceAdapter.addData(formatData(venService.getContent()));

    }

    private   List<VenService.ContentBean> formatData(List<VenService.ContentBean> mDatas){
        for (int i = 0; i < mDatas.size(); i++) {
            if (i % 4 == 0) {
                mDatas.get(i).setDrawableId(R.drawable.index_gszc);
                mDatas.get(i).setTypeColor(R.drawable.coner_dark_blue);
            } else if (i % 4 == 1) {
                mDatas.get(i).setDrawableId(R.drawable.index_ppsb);
                mDatas.get(i).setTypeColor(R.drawable.coner_dark_purple);
            } else if (i % 4 == 2) {
                mDatas.get(i).setDrawableId(R.drawable.index_rlzy);
                mDatas.get(i).setTypeColor(R.drawable.coner_light_blue);
            } else if (i % 4 == 3) {
                mDatas.get(i).setDrawableId(R.drawable.index_gxbt);
                mDatas.get(i).setTypeColor(R.drawable.coner_light_yellow);
            }

        }
        return mDatas;
    }


    @Override
    public void onLoadMoreFail(String error) {
        srl.finishLoadmore();
       if (page<=1){
           page = 1;
           return;
       }
       page--;
    }

    @Override
    protected VentureServicePresenter createPresenter() {
        return new VentureServicePresenter();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        page++;
        mPresenter.loadData(page,true);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
       page = 1;
        mPresenter.loadMindBanner();
        mPresenter.loadData(page,false);
    }
}
