package service;

import dao.UserInfoDao;
import models.UserInfo;
import utils.WriteUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           int state=-1;
           String msg="";
           if(username==null || password==null){
               msg="参数不正确";
           }else{
               UserInfo userInfo=new UserInfo();
               userInfo.setUsername(username);
               userInfo.setPassword(password);
               UserInfoDao userInfoDao=new UserInfoDao();
               try {
                   boolean ret=userInfoDao.selectname(userInfo);
                   if(ret){
                       msg="用户已存在";
                   }else{
                       int res=userInfoDao.add(userInfo);
                       if(res>0){
                           state=200;
                       }
                   }
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }


           }
        HashMap<String,Object> map=new HashMap<>();
           map.put("state",state);
           map.put("msg",msg);
        WriteUtils.writeMap(response,map);
    }
}
