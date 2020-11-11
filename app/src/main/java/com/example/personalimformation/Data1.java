package com.example.personalimformation;

import org.litepal.crud.DataSupport;


public class Data1 extends DataSupport {
    String tiwen;
    String jiaren;
    String time;

    public Data1(){
        super();
    }

    public Data1(String tiwen,String jiaren,String time){
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
