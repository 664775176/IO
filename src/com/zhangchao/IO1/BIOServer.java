package com.zhangchao.IO1;

import java.io.*;
import java.net.*;

public class BIOServer {
    public static void main(String []args){
        Socket socket = null;
        //记录客户端的数量
        int count=0;

        try {
            ServerSocket ss = new ServerSocket(8080);
            while (true) {
                socket = ss.accept();
                socket.setSoTimeout(1);
                //Thread.sleep(2*1000);
                new Thread(new MyRunnable(socket)).start();
                count++;//统计客户端的数量
                System.out.println("客户端的数量："+count);
                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
        }catch (SocketException e1) {
            try {
                if (socket != null)
                    socket.close();
            } catch (Exception e2) {
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
class MyRunnable implements Runnable {
    private Socket socket;
    public MyRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("开启一个线程");
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info=null;
            while((info=br.readLine())!=null){//循环读取客户端的信息
                System.out.println("我是服务器，客户端说："+info);
            }
            //socket.shutdownInput();//关闭输入流
            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();//调用flush()方法将缓冲输出
        }catch (SocketTimeoutException e2) {
            System.err.println("超时。");
        }
        catch (SocketException e1) {
            System.err.println("连接关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
