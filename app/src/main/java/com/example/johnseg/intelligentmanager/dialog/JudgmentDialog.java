package com.example.johnseg.intelligentmanager.dialog;



/*
 *项目名称:  IntelligentManager
 *包名:      com.example.johnseg.intelligentmanager.dialog
 *用户名:    johnseg
 *创建时间:  2018/9/18 19:40
 *描述:
 */

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.johnseg.intelligentmanager.R;

public class JudgmentDialog extends Dialog implements View.OnClickListener{

    private TextView title_layout;
    private TextView message_layout;
    private Button yes_layout;
    private Button no_layout;
    private String title,message;
    private Context context;





    public JudgmentDialog(Context context) {
        super(context, R.style.JudgmentDialogTheme);
    }
    public JudgmentDialog(Context context,String title,String message){
        super(context, R.style.JudgmentDialogTheme);
        this.context=context;
        this.title=title;
        this.message=message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_judgment);
        initView();
        initEven();

    }

    private void initView()
    {
        title_layout=findViewById(R.id.title_layout);
        message_layout=findViewById(R.id.message_layout);
        yes_layout=findViewById(R.id.yes_layout);
        no_layout=findViewById(R.id.no_layout);
    }
    private void initEven()
    {
        title_layout.setText(title);
        message_layout.setText(message);
        yes_layout.setOnClickListener(this);
        no_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.yes_layout:
                super.dismiss();

                break;
            case R.id.no_layout:
                super.dismiss();
                JudgmentDialog judgmentDialog=new JudgmentDialog(context,"再给小甜甜一次机会","小甜甜到底喜不喜欢磕屁?");
                judgmentDialog.show();

                break;

        }
    }
}
