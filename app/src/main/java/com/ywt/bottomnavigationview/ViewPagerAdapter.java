package com.ywt.bottomnavigationview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ywt on 2018/5/6.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

//    public void setList(List<Fragment> list) {
//        list.add(new home_page_Fragment());
//        list.add(new new_car_Fragment());
//        list.add(new used_car_Fragment());
//        list.add(new service_Fragment());
//        list.add(new my_Fragment());
//    }

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        list=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
