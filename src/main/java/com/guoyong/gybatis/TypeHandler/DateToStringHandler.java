package com.guoyong.gybatis.TypeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:DateToStringHandler
 * @Description:TODO
 * @Author: guoyong
 * @Date:2020/8/18 9:15
 **/
@MappedJdbcTypes(JdbcType.VARCHAR)
public class DateToStringHandler extends BaseTypeHandler<Date> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        preparedStatement.setString(i, sdf.format(date));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("获取获取111");
        String columnValue = resultSet.getString(s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (null != columnValue) {
            try {
                return sdf.parse(columnValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("获取获取222");
        String columnValue = resultSet.getString(i);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (null != columnValue) {
            try {
                return sdf.parse(columnValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("获取获取3333");
        String columnValue = callableStatement.getString(i);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (null != columnValue) {
            try {
                return sdf.parse(columnValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
