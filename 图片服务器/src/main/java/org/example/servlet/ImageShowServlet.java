package org.example.servlet;

import org.example.dao.ImageDao;
import org.example.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageShow")
public class ImageShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.解析请求数据 imageId
        String id = req.getParameter("imageId");
        //2.业务处理 2.1根据ID查询图片path字段 2.2通过path找本地图片文件
        Image image = ImageDao.queryOne(Integer.parseInt(id));
        //图片是以二进制数据放在body 同时要指定connectType
        resp.setContentType(image.getContentType());
        //本地图片的绝对路径
        String path = ImageServlet.IMAGE_DIR + image.getPath();
        //io输入流读文件
        FileInputStream fis = new FileInputStream(path);

        //3.返回响应 服务器本地图片的二进制数据
        OutputStream os = resp.getOutputStream();
        //输出流都是输出到body
        byte[] bytes = new byte[1024*8];
        int len;
        while ((len=fis.read(bytes)) !=-1){
             os.write(bytes,0,len);
        }
        os.flush();
        fis.close();
    }
}
