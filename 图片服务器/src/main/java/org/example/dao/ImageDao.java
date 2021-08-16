package org.example.dao;

import org.example.model.Image;
import org.example.util.util;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDao {
    

    public static int queryCount(String md5) {
        //jdbc代码
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取数据库连接
            connection = util.getConnection();
            //2.获取操作命令对象 Statement(connection+sql)
            String sql ="select count(0) connection from image_table where md5=?";
            preparedStatement = connection.prepareStatement(sql);
            //3.执行sql：执行前替换占位符
            preparedStatement.setString(1,md5);
            resultSet = preparedStatement.executeQuery();

            //4.如果是查询语句，需要处理结果集ResultSet
            resultSet.next();
            return resultSet.getInt("connection");


        } catch (SQLException e) {
           throw  new RuntimeException("查询上传图片md5失败"+md5,e);

        }finally {
            //5.释放资源
            util.close(connection,preparedStatement,resultSet);
        }
    }

    public static int insert(Image image) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取数据库连接
            connection = util.getConnection();
            //2.获取操作命令对象 Statement(connection+sql)
            String sql ="insert into image_table values(null,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            //3.执行sql：执行前替换占位符
            preparedStatement.setString(1,image.getImageName());
            preparedStatement.setLong(2,image.getSize());
            preparedStatement.setString(3,image.getUpload_time());
            preparedStatement.setString(4,image.getMd5());
            preparedStatement.setString(5,image.getContentType());
            preparedStatement.setString(6,image.getPath());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw  new RuntimeException("保存新增上传图片出错",e);

        }finally {
            //5.释放资源
            util.close(connection,preparedStatement);
        }

    }

    public static List<Image> queryALL() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            connection=util.getConnection();
            String sql = "select * from image_table";
            ps=connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            List<Image> list = new ArrayList<>();
            while (resultSet.next()){
               Image image = new Image();
               image.setImageId(resultSet.getInt("image_id"));
               image.setImageName(resultSet.getString("image_name"));
               image.setContentType(resultSet.getString("content_type"));
               image.setMd5(resultSet.getString("md5"));
               list.add(image);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException("查询所有图片出错",e);
        }finally {
            util.close(connection,ps,resultSet);
        }
    }

    public static Image queryOne(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try{
            connection = util.getConnection();
            String sql = "select * from image_table where image_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet =ps.executeQuery();
            Image image = null;
            while (resultSet.next()){
                image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setImageName(resultSet.getString("image_name"));
                image.setContentType(resultSet.getString("content_type"));
                image.setMd5(resultSet.getString("md5"));
                image.setPath(resultSet.getString("path"));
            }
            return image;
        }catch (SQLException e){
            throw new RuntimeException("查询一个图片出错",e);
        }finally {
            util.close(connection,ps,resultSet);
        }

    }
}
