package com.guoyong.gybatis.Controller;

import com.alibaba.fastjson.JSON;
import com.guoyong.gybatis.Domain.Blog;
import com.guoyong.gybatis.Mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName:SqlsessionFactoryController
 * @Description:获取Session
 * @Author: guoyong
 * @Date:2020/8/13 19:06
 **/
public class SqlsessionFactoryController {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Blog blog = session.selectOne("com.guoyong.gybatis.Mapper.BlogMapper.selectBlog", 1);
            System.out.println(JSON.toJSON(blog));
        }

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlog(1);
            System.out.println(JSON.toJSON(blog));
        }


    }
}
