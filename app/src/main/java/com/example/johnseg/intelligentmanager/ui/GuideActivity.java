package com.example.johnseg.intelligentmanager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.johnseg.intelligentmanager.R;
import com.example.johnseg.intelligentmanager.adapter.GuideViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.ui
 *用户名:    johnseg
 *创建时间:  2018/9/15 17:46
 *描述:      引导页
 */

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private View view1,view2,view3;
    private List<View> viewList;
    private ImageView point1,point2,point3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        initView();
        viewPager.addOnPageChangeListener(new OnChangeListener());





    }

    public void initView()
    {
        viewPager=findViewById(R.id.guideviewpage);
        view1=this.getLayoutInflater().inflate(R.layout.page_view_1,null);
        view2=this.getLayoutInflater().inflate(R.layout.page_view_2,null);
        view3=this.getLayoutInflater().inflate(R.layout.page_view_3,null);
        viewList=new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewPager.setAdapter(new GuideViewPageAdapter(viewPager,viewList));
        //小圆点初始化
        point1=findViewById(R.id.point1);
        point2=findViewById(R.id.point2);
        point3=findViewById(R.id.point3);
        setPoint(true,false,false);
    }


    private void setPoint(Boolean isCheck1,Boolean isCheck2,Boolean isCheck3)
    {
       if(isCheck1)
       {
           point1.setImageResource(R.drawable.point_green);
       }
       else
       {
           point1.setImageResource(R.drawable.point_black);
       }
        if(isCheck2)
        {
            point2.setImageResource(R.drawable.point_green);
        }
        else
        {
            point2.setImageResource(R.drawable.point_black);
        }
        if(isCheck3)
        {
            point3.setImageResource(R.drawable.point_green);
        }
        else
        {
            point3.setImageResource(R.drawable.point_black);
        }
    }

    //实现ViewPager.OnPageChangeListener的内部类
    private class OnChangeListener implements ViewPager.OnPageChangeListener
    {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
                switch (i)
                {
                    case 0:
                        setPoint(true,false,false);
                        break;
                    case 1:
                        setPoint(false,true,false);
                        break;
                    case 2:
                        setPoint(false,false,true);
                        break;
                }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
