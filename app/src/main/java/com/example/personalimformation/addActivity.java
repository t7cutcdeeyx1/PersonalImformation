package com.example.personalimformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Timestamp;
import java.util.Calendar;

import cc.shinichi.library.tool.utility.ui.ToastUtil;

public class addActivity extends AppCompatActivity {
    EditText editText;
    Button zhengchangbutton;
    Button yichangbutton;
    Button add;

    String tiwen="";
    String shifouzhengchang = "1"; //默认正常
    Timestamp time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add=findViewById(R.id.add);
        editText=findViewById(R.id.editView);
        zhengchangbutton=findViewById(R.id.zhengchang);
        yichangbutton=findViewById(R.id.yichang);
        zhengchangbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shifouzhengchang="1";
            }
        });
        yichangbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shifouzhengchang="2";
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.print(editText.getText().length());
                if (tiwen == ""){
                    Calendar calendar= Calendar.getInstance();
                    time =new Timestamp(calendar.getTimeInMillis());
                    if (shifouzhengchang=="1"){
                        new Data1(tiwen,"正常",time).save();
                    }else {
                        new Data1(tiwen,"异常",time).save();
                    }
                }else {
                    ToastUtil.getInstance()._short(addActivity.this,"请输入体温");
                }
            }
        });
    }
}
