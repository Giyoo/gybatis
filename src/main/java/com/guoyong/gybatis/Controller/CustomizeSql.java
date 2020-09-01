package com.guoyong.gybatis.Controller;

import com.guoyong.gybatis.Domain.Blog;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:CustomizeSql
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/9/1 18:09
 **/
interface BlogCusMapper{
    @Select("select * from Blog where id = #{id}")
    Blog selectBlog(int id);
}

public class CustomizeSql {
    public static void main(String[] args) {
        BlogCusMapper blogCusMapper = (BlogCusMapper) Proxy.newProxyInstance(CustomizeSql.class.getClassLoader(),new Class<?>[]{BlogCusMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select select = method.getAnnotation(Select.class);
                String[] originSqlArr = select.value();
                String originSql = originSqlArr[0];
                Map<String,Object> argMap = buildMethodArgNamesMap(method,args);
                String sql = parseSql(originSql,argMap);
                return null;
            }
        });
        blogCusMapper.selectBlog(1);
    }

    public static Map<String,Object> buildMethodArgNamesMap(Method method,Object[] args){
        Map<String,Object> argMap = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        int index = 0;
        for (Parameter parameter:parameters){
            String argName = parameter.getName();
            argMap.put(argName,args[index]);
            index++;
        }
        return argMap;
    }

    public static String parseSql(String orginalSql,Map<String,Object> argMap){
        int i = 0;
        return null;

    }
 }
