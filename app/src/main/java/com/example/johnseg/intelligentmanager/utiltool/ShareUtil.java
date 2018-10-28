package com.example.johnseg.intelligentmanager.utiltool;
/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.utiltool
 *用户名:    johnseg
 *创建时间:  2018/9/14 17:09
 *描述:
 */

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtil {


    private static final  String NAME="johnseg";


    public static void putString(Context context ,String key,String value)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
       sp.edit().putString(key, value).commit();

    }
    public static String getString(Context context,String key)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return  sp.getString(key,"这是默认值");

    }

    //整型数据
    public static void putInt(Context context ,String key,int value)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();

    }
    public static int getInt(Context context,String key)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return  sp.getInt(key,0);

    }


    //boolean型
    public static void putBoolean(Context context ,String key,Boolean value)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();

    }
    public static Boolean getBoolean(Context context,String key)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return  sp.getBoolean(key,true);

    }

    public static void deleteShare(Context context,String key)
    {
        SharedPreferences sp=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key);

    }



}
