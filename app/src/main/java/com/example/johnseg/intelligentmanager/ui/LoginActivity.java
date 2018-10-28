package com.example.johnseg.intelligentmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.johnseg.intelligentmanager.MainActivity;
import com.example.johnseg.intelligentmanager.R;
import com.example.johnseg.intelligentmanager.entity.User;
import com.example.johnseg.intelligentmanager.utiltool.StaticClass;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.ui
 *用户名:    johnseg
 *创建时间:  2018/9/16 19:40
 *描述:      登录
 */

public class LoginActivity extends AppCompatActivity {

    private EditText username_login;
    private EditText password_login;
    private Button register;
    private Button login_btn;
    private CheckBox checkpassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


    }
    private  void initView()
    {
        register=findViewById(R.id.btn_reg);
        login_btn=findViewById(R.id.btn_login);
        username_login=findViewById(R.id.user_login);
        password_login=findViewById(R.id.pass_login);
        checkpassword=findViewById(R.id.check_password);//记住密码
        register.setOnClickListener(new AllOnClickListener());
        login_btn.setOnClickListener(new AllOnClickListener());



    }
    private class AllOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_login:
                    String username=username_login.getText().toString();
                    String password=password_login.getText().toString();
                    BmobUser user=new BmobUser();
                    user.setUsername(username);
                    user.setPassword(password);
                    Log.d("hare","其实我过了");
                    if(user!=null)
                    {
                        StaticClass.initBmob(LoginActivity.this);
                        user.login(new SaveListener<BmobUser>() {
                            @Override
                            public void done(BmobUser bmobUser, BmobException e) {
                                if (e == null) {
                                    Toast.makeText(LoginActivity.this, "恭喜你，登录成功", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                } else {
                                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "对象user为空", Toast.LENGTH_SHORT).show();
                    }

                    break;
                case R.id.btn_reg:
                        startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                    break;

            }
        }
    }
    //登录模块
   /* private void login(String username,String password)
    {

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if(e==null)
                {
                    Toast.makeText(LoginActivity.this,"恭喜你，登录成功",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    //记住密码*/
}
