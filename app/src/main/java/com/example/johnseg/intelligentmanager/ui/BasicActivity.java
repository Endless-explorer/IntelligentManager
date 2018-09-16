package com.example.johnseg.intelligentmanager.ui;
/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.ui
 *用户名:    johnseg
 *创建时间:  2018/9/14 16:06
 *描述:      activity基类
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class BasicActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            case android.R.id.home:
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
