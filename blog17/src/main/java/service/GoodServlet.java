package service;

import dao.ArticleInfoDao;
import utils.WriteUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class GoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int succ=-1;
         String msg="";
         int id=Integer.parseInt(request.getParameter("id"));
        if(id>0){
             ArticleInfoDao articleInfoDao=new ArticleInfoDao();
             try {
                 succ=articleInfoDao.upgood(id);
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }else{
             msg="参数不正确";
         }
        HashMap<String,Object> map=new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        WriteUtils.writeMap(response,map);
    }
}
