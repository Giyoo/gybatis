package com.guoyong.gybatis.Controller;

import com.alibaba.fastjson.JSON;
import com.guoyong.gybatis.Domain.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:JdbcDemo
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/9/1 17:43
 **/
public class JdbcDemo {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gybatis?characterEncoding=utf-8&serverTimezone=UTC", "root", "123456");
            Statement sm = connection.createStatement();
            sm.execute("select * from Blog");
            ResultSet resultSet = sm.getResultSet();
            List<Blog> list = new ArrayList<>();
            while (resultSet.next()){
                Blog blog = new Blog();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("dec");
                blog.setId(id);
                blog.setName(name);
                blog.setDec(desc);
                list.add(blog);
            }
            System.out.println(JSON.toJSONString(list));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
                }
