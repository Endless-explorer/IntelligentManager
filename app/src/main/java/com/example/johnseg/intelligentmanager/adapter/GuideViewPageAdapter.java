package com.example.johnseg.intelligentmanager.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.adapter
 *用户名:    johnseg
 *创建时间:  2018/9/15 18:33
 *描述:
 */

public class GuideViewPageAdapter extends PagerAdapter {

    private ViewPager viewPager;
    private List<View> viewList=new ArrayList<>();

    public GuideViewPageAdapter(ViewPager viewPager, List<View> viewList) {
        this.viewPager = viewPager;
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));

    }
}
