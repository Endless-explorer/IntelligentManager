package com.example.johnseg.intelligentmanager.ui;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.johnseg.intelligentmanager.R;
import com.example.johnseg.intelligentmanager.entity.User;
import com.example.johnseg.intelligentmanager.utiltool.StaticClass;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.ui
 *用户名:    johnseg
 *创建时间:  2018/9/16 23:09
 *描述:      注册
 */

public class RegistActivity extends BasicActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {
    private EditText user_reg;
    private EditText password_reg;
    private EditText repassword_reg;
    private EditText birthday_reg;
    private EditText signature_reg;
    private EditText email_reg;
    private int sex;
    private Button register;
    private RadioGroup radioGroup;
    private User user;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();

    }
    private  void initView()
    {
        user_reg=findViewById(R.id.user_reg);
        password_reg=findViewById(R.id.password_reg);
        repassword_reg=findViewById(R.id.repass_reg);
        signature_reg=findViewById(R.id.signature_reg);
        birthday_reg=findViewById(R.id.birthday_reg);
        email_reg=findViewById(R.id.email_reg);
        register=findViewById(R.id.btn_register);
        radioGroup=findViewById(R.id.radio_reg);
        radioGroup.setOnCheckedChangeListener(this);
        register.setOnClickListener(this);


    }
    //BUTTON点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_register:
                String username=user_reg.getText().toString();
                String password=password_reg.getText().toString();
                String repassword=repassword_reg.getText().toString();
                String signature=signature_reg.getText().toString();
                String email=email_reg.getText().toString();
                String birthday=birthday_reg.getText().toString();
                if(!TextUtils.isEmpty(username)&!TextUtils.isEmpty(password)
                        &!TextUtils.isEmpty(repassword)&!TextUtils.isEmpty(signature)
                        &!TextUtils.isEmpty(email)&!TextUtils.isEmpty(birthday))
                {
                    if(repassword.equals(password))
                    {
                        StaticClass.initBmob(this);
                        user=new User();
                        user.setBirthday(birthday);
                        user.setSex(sex);
                        user.setSignature(signature);
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setEmail(email);
                        user.signUp(new SaveListener<User>() {
                            @Override
                            public void done(User user, BmobException e) {
                                if(e!=null)
                                {

                                    Toast.makeText(RegistActivity.this,"注册失败"+e.getErrorCode()+e.toString()+e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                                else
                                {

                                    Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                    finish();

                                }

                            }
                        });


                    }
                    else
                    {

                        Toast.makeText(this,"您输入的密码不一致",Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {


                    Toast.makeText(this,"输入框不能为空",Toast.LENGTH_SHORT).show();
                }


                break;


        }

    }


    //RADIOGROUP选中事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.boy_reg:
                sex=1;  //1代表男性，0代表女性
                break;
            case R.id.girl_reg:
                sex=0;  //1代表男性，0代表女性
                break;
        }

    }
}
