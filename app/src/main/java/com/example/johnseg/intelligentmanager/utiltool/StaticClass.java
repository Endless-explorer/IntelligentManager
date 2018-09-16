package com.example.johnseg.intelligentmanager.utiltool;
/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.utiltool
 *用户名:    johnseg
 *创建时间:  2018/9/14 17:08
 *描述:      存放静态数据
 */

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;

import cn.bmob.v3.Bmob;

public class StaticClass {

    //bmob数据库的application
    public static final String BMOB_APP_ID="b2ff0614a52a68c48b7d42ffb57dda69";
    //腾讯bugly的application id
    public static final String BUGLY_APP_ID="b809a59b48";





    //腾讯bugly初始化方法
    public static void initBugly(Context context)
    {
        CrashReport.initCrashReport(context.getApplicationContext(), StaticClass.BUGLY_APP_ID, false);
    }
    //Bmob初始化方法
    public static void initBmob(Context context)
    {
        Bmob.initialize(context, StaticClass.BMOB_APP_ID);
    }
}
