package com.qingmang;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.qingmang.home.HomeFragment;
import com.qingmang.home.MyFragment;
import com.qingmang.home.PeopleFragment;
import com.qingmang.uilibrary.BottomBar;
import com.qingmang.uilibrary.BottomBarTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.qingmang.R.id.fl_container;

public class MainActivity extends AppCompatActivity {

    @BindView(fl_container)
    FrameLayout flContainer;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private PeopleFragment findFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment(savedInstanceState);
        initView();
    }


    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.addItem(new BottomBarTab(this, R.drawable.icon_index,R.drawable.icon_index_cur))
                .addItem(new BottomBarTab(this, R.drawable.icon_people,R.drawable.icon_people_cur))
                .addItem(new BottomBarTab(this, R.drawable.icon_my,R.drawable.icon_my_cur));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               switch (position){
                   case 0:
                       if(null==homeFragment){
                           homeFragment = HomeFragment.newInstance();
                           transaction.add(R.id.fl_container,homeFragment);
                       }
                           showHideFragment(homeFragment);
                       break;
                   case 1:
                       if(null==findFragment){
                           findFragment = PeopleFragment.newInstance();
                           transaction.add(R.id.fl_container,findFragment);
                       }
                       showHideFragment(findFragment);
                       break;
                   case 2:
                       if(null==myFragment){
                           myFragment = MyFragment.newInstance();
                           transaction.add(R.id.fl_container,myFragment);
                       }
                       showHideFragment(myFragment);
                       break;

               }
                transaction.commit();

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final Fragment currentFragment = mFragments.get(position);
//                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
//
//                // 如果不在该类别Fragment的主页,则回到主页;
//                if (count > 1) {
//                    if (currentFragment instanceof ZhihuFirstFragment) {
//                        currentFragment.popToChild(FirstHomeFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuSecondFragment) {
//                        currentFragment.popToChild(ViewPagerFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuThirdFragment) {
//                        currentFragment.popToChild(ShopFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuFourthFragment) {
//                        currentFragment.popToChild(MeFragment.class, false);
//                    }
//                    return;
//                }


                // 这里推荐使用EventBus来实现 -> 解耦
//                if (count == 1) {
//                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
//                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                    EventBus.getDefault().post(new TabSelectedEvent(position));
//                }
            }
        });
        mBottomBar.setCurrentItem(0);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
     FragmentManager manager = getSupportFragmentManager();
        if (null!=homeFragment&&homeFragment.isAdded()) {
            manager.putFragment(outState, "homeFragment", homeFragment);
        }
        if (null!=myFragment&&myFragment.isAdded()) {
            manager.putFragment(outState, "myFragment", myFragment);
        }
        if (null!=findFragment&&findFragment.isAdded()) {
            manager.putFragment(outState, "findFragment", findFragment);
        }

    }

    /**
     * 初始化fragment的记忆状态
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (savedInstanceState != null) {

            homeFragment = (HomeFragment) getSupportFragmentManager().getFragment(savedInstanceState, "homeFragment");
            myFragment = (MyFragment) getSupportFragmentManager().getFragment(savedInstanceState, "myFragment");
            findFragment = (PeopleFragment) getSupportFragmentManager().getFragment(savedInstanceState, "findFragment");

        } else {
            homeFragment = HomeFragment.newInstance();
//            myFragment = MyFragment.newInstance();
//            findFragment = FindFragment.newInstance();
        }
        if(null!=homeFragment)
        mFragments.add(homeFragment);
        if(null!=findFragment)
        mFragments.add(findFragment);
        if(null!=myFragment)
        mFragments.add(myFragment);

        if(null!=homeFragment)
        transaction.add(R.id.fl_container,homeFragment);
        if(null!=findFragment)
        transaction.add(R.id.fl_container,findFragment);
        if(null!=myFragment)
        transaction.add(R.id.fl_container,myFragment);

        if(null!=myFragment)
        transaction.hide(myFragment);
        if(null!=findFragment)
        transaction.hide(findFragment);
        transaction.commit();
    }
    public void showHideFragment(Fragment fragment){
       FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if(!mFragments.contains(fragment)){
            mFragments.add(fragment);
        }
        for (Fragment f:mFragments) {
            if(fragment.equals(f)){
                fragmentTransaction.show(fragment);
            }else
                fragmentTransaction.hide(f);

        }
        fragmentTransaction.commit();
    }
}
