package com.guoyong.gybatis.Mapper;

import com.guoyong.gybatis.Domain.Blog;

import java.util.Map;

/**
 * @ClassName:BlobMapper
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/8/14 15:35
 **/
public interface BlogMapper {
    Blog selectBlog(int id);
    Blog selectBlogByMap(Map<String,String> map);
}
