package com.zhangchao.IO1;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class BIOClient {
    public static void main(String []args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                addClient();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                addClient();
            }
        }).start();
    }
    public static void  addClient(){
        byte[] res = null;
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            socket.setSoTimeout(1);
            String string = "s";

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(string);
            Thread.sleep(2*1000);
            bw.flush();
            socket.shutdownOutput();

            //3.获取输入流，用来读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器端返回的信息是：" + info);
            }

            //4.关闭资源
            br.close();
            is.close();
            socket.close();
        }catch (SocketTimeoutException e2) {
            System.err.println("超时。");
        }  catch (SocketException e1) {
            try {
                if (socket != null)
                    socket.close();
            } catch (Exception e2) {
            }
        }catch (Exception e) {
            try {
                if (socket != null)
                    socket.close();
            } catch (Exception e1) {
            }
        }
    }
}
