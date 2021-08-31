package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
*通用数据库的操作
*1.配置一个对外的connect对象
* 2.提供关闭方法
* */
public class DBUtils {
    //1.对外提供connect对象
    private static MysqlDataSource dataSource = null;
    public static Connection getConnect() throws SQLException {
        if (dataSource == null){
            //初次调用，先初始化
            dataSource = new MysqlDataSource();
            //1.设置连接的服务器地址
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/java17blog?characterEncoding=utf-8");
            //设置用户名
            dataSource.setUser("root");
            //设置密码
            dataSource.setPassword("111111");
        }
        return dataSource.getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        if (resultSet!=null) {
            resultSet.close();
        }
        if (statement!=null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }

}
