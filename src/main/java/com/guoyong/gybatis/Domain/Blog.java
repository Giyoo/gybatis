package com.guoyong.gybatis.Domain;

import java.util.Date;

/**
 * @ClassName:Blog
 * @Description:Blog
 * @Author: guoyong
 * @Date:2020/8/14 14:21
 **/
public class Blog {
    int id;
    String name;
    String dec;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
