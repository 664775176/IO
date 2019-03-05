package com.zhangchao.IO2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServerSocket3 {
    public static void main(String[] args) throws Exception {
        //1.创建serverSocket
        ServerSocket serverSocket = new ServerSocket();

        //2.设置端口号
        serverSocket.bind(new InetSocketAddress(8989));
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while(true) {
            Socket socket = serverSocket.accept();
            executorService.submit(new Runnable() {
                //3.获取报文
                @Override
                public void run() {
                    try {
                        //打印当前线程ID
                        System.out.println("当前线程ID："+Thread.currentThread().getId());

                        //a.获得客户端的意图   request
                        InputStream is = socket.getInputStream();
                        //字符流和字节流的转换
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);

                        //存储读取的数据
                        StringBuilder sb = new StringBuilder();
                        String line = null;
                        //读取数据
                        while((line = br.readLine()) != null){
                            //将数据存储在StringBuilder中
                            sb.append(line);
                        }
                        System.out.println("服务器收到的数据："+sb.toString());
                        //b.返回客户端数据
                        OutputStream os = socket.getOutputStream();
                        //获得输出流
                        PrintWriter pw = new PrintWriter(os);
                        pw.write("接收的数据："+sb.toString()+"  服务器已经接收到数据");
                        //将数据发送
                        pw.flush();
                        //关闭流
                        br.close();
                        pw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
