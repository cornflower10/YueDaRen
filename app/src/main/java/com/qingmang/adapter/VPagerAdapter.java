package com.qingmang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qingmang.home.PeopleChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class VPagerAdapter extends FragmentPagerAdapter {
    List<PeopleChildFragment> fragments = new ArrayList<>();

    public VPagerAdapter(FragmentManager fm) {
        super(fm);

        for (int i = 0; i < 5; i++) {
            fragments.add(PeopleChildFragment.newInstance(i));
        }
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
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PAGE 0";
            case 1:
                return "PAGE 1";
            case 2:
                return "PAGE 2";
            case 3:
                return "PAGE 3";
            case 4:
                return "PAGE 4";
        }
        return null;
    }

}
