package com.example.johnseg.intelligentmanager.entity;

import android.text.TextUtils;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.entity
 *用户名:    johnseg
 *创建时间:  2018/9/16 23:24
 *描述:      用户bean
 */

public class User extends BmobUser {

    private int sex;
    private String birthday;
    private String signature;
    /*private String username;
    private String password;
    private String email;*/




    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

   /* public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/
}
