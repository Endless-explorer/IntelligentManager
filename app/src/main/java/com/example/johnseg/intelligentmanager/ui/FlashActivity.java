package com.example.johnseg.intelligentmanager.ui;
/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.ui
 *用户名:    johnseg
 *创建时间:  2018/9/14 16:42
 *描述:      闪屏页
 */


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.johnseg.intelligentmanager.MainActivity;
import com.example.johnseg.intelligentmanager.R;
import com.example.johnseg.intelligentmanager.utiltool.ShareUtil;

public class FlashActivity extends AppCompatActivity{

    private Handler handler=new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_flash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isfirst()) {
                    Intent intent = new Intent(FlashActivity.this, GuideActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(FlashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        }, 2000);
        super.onCreate(savedInstanceState);
    }

    private boolean isfirst()
    {
        if(ShareUtil.getBoolean(this,"isfirst"))
        {
            ShareUtil.putBoolean(this,"isfirst",false);
            return true;
        }
        else
        {
           return false;
        }


    }
}
