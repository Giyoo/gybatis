package com.guoyong.gybatis.Controller;

import com.guoyong.gybatis.Domain.Blog;
import org.apache.ibatis.annotations.Select;
import org.springframework.util.StringUtils;

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
    @Select("select * from Blog where id = #{id} and name = #{name}")
    Blog selectBlog(int id,String name);
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
                System.out. println(sql);
                return null;
            }
        });
        blogCusMapper.selectBlog(1,"haha");
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
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<orginalSql.length();i++){
            if (orginalSql.charAt(i) == '#'){
                if (orginalSql.charAt(i+1) != '{'){
                    throw new RuntimeException("parse sql error:"+orginalSql+" at"+i+1);
                }
                StringBuilder argName = new StringBuilder();
                i = parseSqlArg(i+1,argName,orginalSql);
                Object argValue =  argMap.get(argName.toString());
                sb.append(argValue.toString());
                continue;
            }else {
                sb.append(orginalSql.charAt(i));
            }
        }
        return sb.toString();
    }
    public static int parseSqlArg(int index,StringBuilder argName,String orginalSql){
        index++;
        for (;index<orginalSql.length();index++){
            if (orginalSql.charAt(index) != '}'){
                argName.append(orginalSql.charAt(index));
            }else {
                return index;
            }
        }
        throw new RuntimeException("parse sql error:"+orginalSql);
    }
 }
