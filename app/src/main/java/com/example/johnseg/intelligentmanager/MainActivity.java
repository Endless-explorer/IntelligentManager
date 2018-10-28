package com.example.johnseg.intelligentmanager;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.johnseg.intelligentmanager.adapter.FragmentAdapter;
import com.example.johnseg.intelligentmanager.dialog.JudgmentDialog;
import com.example.johnseg.intelligentmanager.fragment.Fragment_1;
import com.example.johnseg.intelligentmanager.fragment.Fragment_2;
import com.example.johnseg.intelligentmanager.fragment.Fragment_3;
import com.example.johnseg.intelligentmanager.fragment.Fragment_4;
import com.example.johnseg.intelligentmanager.ui.BasicActivity;
import com.example.johnseg.intelligentmanager.utiltool.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends BasicActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String>   titlelist;
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StaticClass.initBugly(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        StaticClass.initBmob(this);





    }

    private void initData()
    {
        JudgmentDialog judgmentDialog=new JudgmentDialog(this,"社会调查","小甜甜喜欢磕屁吗？");
        judgmentDialog.show();

        titlelist=new ArrayList<>();
        fragmentList=new ArrayList<>();
        titlelist.add("服务管家");
        titlelist.add("微信精选");
        titlelist.add("美女合集");
        titlelist.add("个人中心");
        fragmentList.add(new Fragment_1());
        fragmentList.add(new Fragment_2());
        fragmentList.add(new Fragment_3());
        fragmentList.add(new Fragment_4());
    }

    private void initView()
    {
        viewPager=findViewById(R.id.myviewpage);
        tabLayout=findViewById(R.id.mytablayout);
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragmentList,titlelist));
        tabLayout.setupWithViewPager(viewPager);




    }
}
