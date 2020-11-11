package com.example.personalimformation;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cc.shinichi.library.tool.utility.ui.ToastUtil;

public class addActivity extends AppCompatActivity {
    EditText editText;
    Button zhengchangbutton;
    Button yichangbutton;
    Button add;

    String tiwen="";
    String shifouzhengchang = "1"; //默认正常
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
                //灰色
                int colorb1= Color.parseColor("#F8F7F7");
                int colort1= Color.parseColor("#B4B4B4");

                //蓝色
                int colorb2= Color.parseColor("#27A6F5");
                int colort2= Color.parseColor("#414141");

                zhengchangbutton.setBackgroundColor(colorb2);
                zhengchangbutton.setTextColor(colort2);

                yichangbutton.setBackgroundColor(colorb1);
                yichangbutton.setTextColor(colort1);
            }
        });

        yichangbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shifouzhengchang="2";
                //灰色
                int colorb1= Color.parseColor("#F8F7F7");
                int colort1= Color.parseColor("#B4B4B4");

                //蓝色
                int colorb2= Color.parseColor("#27A6F5");
                int colort2= Color.parseColor("#414141");

                zhengchangbutton.setBackgroundColor(colorb1);
                zhengchangbutton.setTextColor(colort1);

                yichangbutton.setBackgroundColor(colorb2);
                yichangbutton.setTextColor(colort2);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiwen=editText.getText().toString();
                if (!tiwen.equals("")){
                    Calendar calendar= Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentDate = sdf.format(calendar.getTime());

                    Data1 data1 =new Data1();
                    if (shifouzhengchang=="1"){
                        data1=new Data1(tiwen,"正常",currentDate);
                        data1.save();
                    }else {
                        data1=new Data1(tiwen,"异常",currentDate);
                        data1.save();
                    }
                    Intent intent_return = new Intent();
                    intent_return.putExtra("tiwen",data1.tiwen);
                    intent_return.putExtra("jiaren",data1.jiaren);
                    intent_return.putExtra("time",data1.time);
                    setResult(RESULT_OK,intent_return);
                    finish();
                }else {
                    ToastUtil.getInstance()._short(addActivity.this,"请输入体温");
                }
            }
        });
    }
}
