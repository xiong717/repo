package org.example.test;

import java.io.*;

public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        //获取文件的输入流 输出流
        InputStream is = new FileInputStream("D:\\mag\\tup.jpg");

        FileOutputStream fos = new FileOutputStream("D://picture//1.jpg");

        //读取输入流的东西到输出流
        byte[] bytes = new byte[1024];//1024个字节 1kb
        int len;
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        //关闭输出流 输入流
        is.close();
        fos.close();
    }
}
