package com.qingmang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.qingmang.serviceIntroduce.ServiceIntroducePagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class ServicePagerAdapter extends FragmentStatePagerAdapter {
    List<ServiceIntroducePagerFragment> fragments = new ArrayList<>();
    List<String> catesBeanList;
    private String [] strings;

    public ServicePagerAdapter(FragmentManager fm, List<String> catesBeanList,String [] strings) {
        super(fm);
        this.catesBeanList = catesBeanList;
        for (int i = 0; i < catesBeanList.size(); i++) {
            fragments.add(ServiceIntroducePagerFragment.newInstance(catesBeanList.get(i)));
        }
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return catesBeanList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return   strings[position];
    }

}
