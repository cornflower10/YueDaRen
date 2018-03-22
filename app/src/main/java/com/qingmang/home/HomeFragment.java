package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingmang.R;
import com.qingmang.adapter.WebBannerAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.Message;
import com.qingmang.uilibrary.banner.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class HomeFragment extends BaseMvpFragment<HomePresenter,HomeView> implements HomeView<Message> {
    @BindView(R.id.bl)
    BannerLayout bl;
    @BindView(R.id.tv_ad)
    TextView tvAd;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.tv_amount_mind)
    TextView tvAmountMind;
    @BindView(R.id.tv_des_mind)
    TextView tvDesMind;
    @BindView(R.id.tv_amount_last)
    TextView tvAmountLast;
    @BindView(R.id.tv_des_last)
    TextView tvDesLast;
    @BindView(R.id.tv_name_company)
    TextView tvNameCompany;
    @BindView(R.id.tv_tip_company)
    TextView tvTipCompany;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.tv_name_brand)
    TextView tvNameBrand;
    @BindView(R.id.tv_tip_brand)
    TextView tvTipBrand;
    @BindView(R.id.tv_name_last)
    TextView tvNameLast;
    @BindView(R.id.tv_tip_last)
    TextView tvTipLast;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.rv_message)
    RecyclerView rvMessage;
    WebBannerAdapter mzBannerAdapter;
    List<Banner.ContentBean> list = new ArrayList<>();
    @Override
    protected View getRootView() {
        return null;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
        LogManager.i("HomeFragment-----");

        mPresenter.loadTopBanner();
         mzBannerAdapter=new WebBannerAdapter(mContext,list);
        mzBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        bl.setAdapter(mzBannerAdapter);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("HomeFragment-----" + isVisible);
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @OnClick({R.id.rL_gszc, R.id.rl_rlzy, R.id.rl_ppsb, R.id.rl_gwbt, R.id.tv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rL_gszc:
                break;
            case R.id.rl_rlzy:
                break;
            case R.id.rl_ppsb:
                break;
            case R.id.rl_gwbt:
                break;
            case R.id.tv_more:
                break;
        }
    }

    @Override
    public void onError(String msg) {
        showToast(msg);
    }

    @Override
    public void onDataSuccess(Message message) {

    }

    @Override
    public void onBannerSuccess(Banner banner) {
        if(null!=banner.getContent()&&banner.getContent().size()>0){
            list.clear();
            list.addAll(banner.getContent());
            mzBannerAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }
}
