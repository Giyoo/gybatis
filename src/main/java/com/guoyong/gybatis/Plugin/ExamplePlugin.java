package com.guoyong.gybatis.Plugin;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @ClassName:ExamplePlugin
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/8/18 9:51
 **/
@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class ExamplePlugin implements Interceptor {

    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        System.out.println("执行sql参数：{}"+JSON.toJSONString(invocation.getArgs()));
        Object returnObject = invocation.proceed();
        System.out.println("执行sql结果：{}"+JSON.toJSONString(returnObject));
        // implement post processing if need
        return returnObject;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
