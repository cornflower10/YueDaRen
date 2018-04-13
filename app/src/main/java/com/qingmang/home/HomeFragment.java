package com.qingmang.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qingmang.MainActivity;
import com.qingmang.R;
import com.qingmang.WebActivity;
import com.qingmang.adapter.MessageAdapter;
import com.qingmang.adapter.WebBannerAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.hotmessage.HotMessageActivity;
import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.moudle.entity.HotService;
import com.qingmang.moudle.entity.Message;
import com.qingmang.serviceIntroduce.ServiceIntroduceActivity;
import com.qingmang.uilibrary.banner.BannerLayout;
import com.qingmang.uilibrary.marqueen.SimpleMF;
import com.qingmang.uilibrary.marqueen.SimpleMarqueeView;
import com.qingmang.uilibrary.marqueen.util.OnItemClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class HomeFragment extends BaseMvpFragment<HomePresenter, HomeView> implements
        HomeView<Message> ,OnRefreshListener{
    @BindView(R.id.bl)
    BannerLayout bl;
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
    com.yyydjk.library.BannerLayout iv;
    @BindView(R.id.rv_message)
    RecyclerView rvMessage;
    WebBannerAdapter mzBannerAdapter;
    List<Banner.ContentBean> list = new ArrayList<>();
    List<String> banners = new ArrayList<>();
    List<Banner.ContentBean> listMindBanner = new ArrayList<>();
    List<HotMessage.ContentBean> hotMessages = new ArrayList<>();
    @BindView(R.id.marqueeView)
    SimpleMarqueeView marqueeView;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;


    private MessageAdapter messageAdapter;
    private List<HotService> services = new ArrayList<>();

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
        loadData();
        srl.setOnRefreshListener(this);
        srl.setEnableLoadmore(false);
        messageAdapter = new MessageAdapter(hotMessages);
        messageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.startWebViewActivity(mContext, hotMessages.get(position).getTitle(), String.valueOf(hotMessages.get(position).getId()));
            }
        });
        rvMessage.setAdapter(messageAdapter);
        rvMessage.setLayoutManager(new LinearLayoutManager(mContext));
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HotMessageActivity.class);
            }
        });

    }

    private void loadData(){
        mPresenter.loadTopBanner();
        mPresenter.loadMindBanner();
        mPresenter.loadHotService();
        mPresenter.loadHotMessage();
    }

    private void initQuickMessage(final List<HotMessage.ContentBean> list) {
        SimpleMF<String> marqueeFactory3 = new SimpleMF<>(mContext);
        List<String> datas3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i > 4)
                break;
            datas3.add(list.get(i).getIntroduce());
        }
        marqueeFactory3.setData(datas3);
        marqueeView.setMarqueeFactory(marqueeFactory3);
        marqueeView.startFlipping();

        marqueeView.setOnItemClickListener(new OnItemClickListener<TextView, Object>() {
            @Override
            public void onItemClickListener(TextView mView, Object mData, int mPosition) {
                WebActivity.startWebViewActivity(mContext, list.get(mPosition).getTitle(),
                        String.valueOf(list.get(mPosition).getId()));
            }
        });
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


    @OnClick({R.id.rL_gszc, R.id.rl_rlzy, R.id.rl_ppsb,
            R.id.rl_gwbt, R.id.rl_1, R.id.rl_2, R.id.rl_3})
    public void onViewClicked(View view) {
        if (services.size() >= 7) {
            int tip = 0;
            switch (view.getId()) {
                case R.id.rL_gszc:
                    tip = 3;
                    break;
                case R.id.rl_rlzy:
                    tip = 4;
                    break;
                case R.id.rl_ppsb:
                    tip = 5;
                    break;
                case R.id.rl_gwbt:
                    tip = 6;
                    break;
//                case R.id.tv_more:
//                    break;
                case R.id.rl_1:
                    tip = 0;
                    break;
                case R.id.rl_2:
                    tip = 1;
                    break;
                case R.id.rl_3:
                    tip = 2;
                    break;

            }
            ServiceIntroduceActivity.startActivity(mContext, services.get(tip).getId());
        }

    }

    @Override
    public void onError(String msg) {
        showToast(msg);
        srl.finishRefresh();
    }

    @Override
    public void onDataSuccess(Message message) {
        srl.finishRefresh();
    }

    @Override
    public void onBannerSuccess(Banner banner) {
        srl.finishRefresh();
        if (null != banner.getContent() && banner.getContent().size() > 0) {
            list.clear();
            list.addAll(banner.getContent());
            banners.clear();
            for (int i = 0; i < list.size(); i++) {
                banners.add(list.get(i).getLogo());
            }

            mzBannerAdapter = new WebBannerAdapter(mContext, banners);
            mzBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    WebActivity.startWebViewActivity(mContext, list.get(position).getTitle(),
                            String.valueOf(list.get(position).getId()));
                }
            });
            bl.setAdapter(mzBannerAdapter);
            bl.setAutoPlaying(true);
            LogManager.i("bl----" + bl.isPlaying());


        }

    }

    @Override
    public void onMindBannerSuccess(Banner banner) {
        srl.finishRefresh();
        listMindBanner = banner.getContent();
        if (null == listMindBanner||listMindBanner.size()==0)
            return;
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < listMindBanner.size(); i++) {
            list.add(listMindBanner.get(i).getLogo());
        }
        iv.setViewUrls(list);
        iv.setOnBannerItemClickListener(new com.yyydjk.library.BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int i) {
                WebActivity.startWebViewActivity(mContext, listMindBanner.get(i).getTitle(),
                        String.valueOf(listMindBanner.get(i).getId()));

            }
        });

    }

    @Override
    public void onHotServieSuccess(List<HotService> services) {
        srl.finishRefresh();
        this.services = services;
        HotService hotService1 = services.get(0);
        tvAmount.setText(hotService1.getPrice() + "元");
        tvDes.setText(hotService1.getName());

        HotService hotService2 = services.get(1);
        tvAmountMind.setText(hotService2.getPrice() + "元");
        tvDesMind.setText(hotService2.getName());

        HotService hotService3 = services.get(2);
        tvAmountLast.setText(hotService3.getPrice() + "元");
        tvDesLast.setText(hotService3.getName());

        tvNameCompany.setText(services.get(3).getName());
        tvName.setText(services.get(4).getName());
        tvNameBrand.setText(services.get(5).getName());
        tvNameLast.setText(services.get(6).getName());

    }

    @Override
    public void onHotMessageSuccess(HotMessage hotMessage) {
        srl.finishRefresh();
        messageAdapter.replaceData(hotMessage.getContent());
        initQuickMessage(hotMessage.getContent());
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }


    @OnClick(R.id.tv_service_more)
    public void onViewClicked() {
        ((MainActivity) mContext).chooseTab(1);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        loadData();
    }
}
