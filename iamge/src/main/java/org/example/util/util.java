package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class util {
    private  static final ObjectMapper m = new ObjectMapper();

    //数据库连接
    private static final MysqlDataSource ds = new MysqlDataSource();


    static {
        ds.setURL("jdbc:mysql://localhost:3306/image_system");
        ds.setUser("root");
        ds.setPassword("111111");
        ds.setUseSSL(false);
        ds.setCharacterEncoding("UTF-8");
    }
    /*
    * 把java对象序列化为json字符串
    * */
    public static String serialize(Object o){
        try {
            return m.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("序列化java对象失败"+o,e);
            //JsonProcessingException编译型异常 变化为运行时异常
        }
    }
/*
*  获取数据库连接
* */
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接获取失败",e);
        }
    }

    public static void close(Connection c, Statement s, ResultSet rs){
        try {
            if (rs!=null) rs.close();
            if (s!=null) s.close();
            if (c!=null) c.close();
        } catch (SQLException e) {
           throw new RuntimeException("释放数据库资源失败",e);
        }
    }

    //上面方法的重载
    public static void close(Connection c,Statement s){
        close(c, s,null);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
