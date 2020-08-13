package com.guoyong.mybatis.gybatis.Controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName:SqlsessionFactoryController
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/8/13 19:06
 **/
public class SqlsessionFactoryController {
    public static void main(String[] args) throws IOException {
        String resource = "E:\\gybatis\\src\\main\\resources\\mybatis-config.xml";
        File file = new File(resource);
        InputStream inputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);

    }
}
