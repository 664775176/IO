package com.zhangchao.IO2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 客户端
 * @author MOTUI
 *
 */
public class BIOClientSocket1 {

    public static void main(String[] args) throws Exception {

        //1.创建Socket
        Socket socket = new Socket();

        //2.连接服务器
        socket.connect(new InetSocketAddress("127.0.0.1",8989));

        //a.发送数据到服务器
        OutputStream os = socket.getOutputStream();
        //获得输出流
        PrintWriter pw = new PrintWriter(os);
        pw.write("这是客户端数据");
        //将数据发送
        pw.flush();

        //告知服务器已经到了流的结尾
        socket.shutdownOutput();

        //b.获得服务器的回应
        InputStream is = socket.getInputStream();
        //字符流和字节流的转换
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        Thread.sleep(10000);
        //存储读取的数据
        StringBuilder sb = new StringBuilder();
        String line = null;
        //读取数据
        while((line = br.readLine()) != null){
            //将数据存储在StringBuilder中
            sb.append(line);
        }
        //打印服务器回应数据
        System.out.println(sb.toString());

        //关闭流
        br.close();
        pw.close();
        socket.close();
    }
}