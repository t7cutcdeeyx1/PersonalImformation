package com.example.personalimformation;

import org.litepal.crud.DataSupport;

import java.sql.Timestamp;

public class Data1 extends DataSupport {
    String tiwen;
    String jiaren;
    Timestamp time;

    public Data1(String tiwen,String jiaren,Timestamp time){
        this.tiwen = tiwen;
        this.jiaren = jiaren;
        this.time = time;
    }

    public String getTiwen() {
        return tiwen;
    }

    public void setTiwen(String tiwen) {
        this.tiwen = tiwen;
    }

    public String getJiaren() {
        return jiaren;
    }

    public void setJiaren(String jiaren) {
        this.jiaren = jiaren;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
