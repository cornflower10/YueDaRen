package com.qingmang.home;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.qingmang.R;
import com.qingmang.adapter.VPagerAdapter;
import com.qingmang.adapter.VTabAdapter;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;
import com.qingmang.custom.VerticalViewPager;
import com.qingmang.custom.verticaltablayout.TabView;
import com.qingmang.custom.verticaltablayout.VerticalTabLayout;
import com.qingmang.moudle.entity.Service;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class PeopleFragment extends BaseMvpFragment<FindPresenter, FindView> implements FindView<Service> {

    @BindView(R.id.tablayout)
    VerticalTabLayout tablayout;
    @BindView(R.id.verticalviewpager)
    VerticalViewPager verticalviewpager;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;

    private List<Service.CatesBean> catesBeans = new ArrayList<>();

    private static final float MIN_SCALE = 0.75f;
    private static final float MIN_ALPHA = 0.75f;
    private long id;
    private VTabAdapter vTabAdapter;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
//        vTabAdapter = new VTabAdapter(mContext, catesBeans);
        LogManager.i("FindFragment-----");

        tablayout.setTabAdapter(new VTabAdapter(mContext, catesBeans));
        tablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                verticalviewpager.setCurrentItem(position);
                id = catesBeans.get(position).getId();
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
        verticalviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tablayout.setTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        verticalviewpager.setAdapter(new VPagerAdapter(getFragmentManager(), catesBeans));
        verticalviewpager.setPageMargin(getResources().
                getDimensionPixelSize(R.dimen.pagemargin));
        verticalviewpager.setPageMarginDrawable(new ColorDrawable(
                getResources().getColor(android.R.color.holo_green_dark)));

        verticalviewpager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.setAlpha(0);

                } else if (position <= 1) { // [-1,1]
                    // Modify the default slide transition to shrink the page as well
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationY(vertMargin - horzMargin / 2);
                    } else {
                        view.setTranslationY(-vertMargin + horzMargin / 2);
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.setAlpha(0);
                }
            }
        });

        loadViewHelper.showLoading("加载中...");
        mPresenter.loadData(1);

    }

    public static PeopleFragment newInstance() {

        Bundle args = new Bundle();

        PeopleFragment fragment = new PeopleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {

        LogManager.i("FindFragment-----" + isVisible);
    }

    @Override
    protected FindPresenter createPresenter() {
        return new FindPresenter();
    }

    @Override
    protected View getRootView() {
        return llRoot;
    }

    @Override
    public void onError(String msg) {
        showToast(msg);
    }

    @Override
    public void onDataSuccess(Service service) {
        LogManager.i("-------onDataSuccess------");
    }

}
