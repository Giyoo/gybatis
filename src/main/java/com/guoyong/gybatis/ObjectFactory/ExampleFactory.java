package com.guoyong.gybatis.ObjectFactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * @ClassName:ExampleFactory
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/8/18 11:09
 **/
public class ExampleFactory extends DefaultObjectFactory {
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        System.out.println("初始化参数：［"+properties.toString()+"]");
    }


    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type, constructorArgTypes, constructorArgs);
        System.out.println("创建对象方法："+result.getClass().getSimpleName());
        return result;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
