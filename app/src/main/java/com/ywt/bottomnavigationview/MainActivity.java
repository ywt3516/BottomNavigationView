package com.ywt.bottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.ywt.bottomnavigationview.Frgment.Fragment_home_page;
import com.ywt.bottomnavigationview.Frgment.Fragment_my;
import com.ywt.bottomnavigationview.Frgment.Fragment_new_car;
import com.ywt.bottomnavigationview.Frgment.Fragment_service;
import com.ywt.bottomnavigationview.Frgment.Fragment_used_car;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home_page:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.new_car:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.used_car:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.service:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.my:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // 为ViewPager添加页面改变事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 将当前的页面对应的底部标签设为选中状态
                navigation.getMenu().getItem(position).setChecked(true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        //构造适配器
        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new Fragment_home_page());
        fragments.add(new Fragment_new_car());
        fragments.add(new Fragment_used_car());
        fragments.add(new Fragment_service());
        fragments.add(new Fragment_my());
        //设定适配器
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }

}
























