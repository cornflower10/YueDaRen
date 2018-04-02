package com.qingmang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qingmang.R;
import com.qingmang.home.PeopleChildFragment;
import com.qingmang.moudle.entity.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class VPagerAdapter extends FragmentPagerAdapter {
    List<PeopleChildFragment> fragments = new ArrayList<>();
    List<Service.CatesBean> catesBeanList;

    public VPagerAdapter(FragmentManager fm,
                         List<Service.CatesBean> catesBeanList) {
        super(fm);
        this.catesBeanList = catesBeanList;
        for (int i = 0; i < catesBeanList.size(); i++) {
            if(i%4==0){
                catesBeanList.get(i).setDrawableId(R.drawable.entrep_gszc);
            }else if(i%4==1){
                catesBeanList.get(i).setDrawableId(R.drawable.entrep_dljz);
            }
            else if(i%4==2){
                catesBeanList.get(i).setDrawableId(R.drawable.entrep_zzq);
            }
            else if(i%4==3){
                catesBeanList.get(i).setDrawableId(R.drawable.entrep_flfw);
            }
            fragments.add(PeopleChildFragment.newInstance(catesBeanList.get(i).getId(),
                    catesBeanList.get(i).getDrawableId()));
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
        return catesBeanList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return   catesBeanList.get(position).getName();
    }

}
