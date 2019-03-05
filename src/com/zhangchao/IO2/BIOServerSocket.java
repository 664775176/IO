package com.zhangchao.IO2;

    import java.io.BufferedReader;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.io.PrintWriter;
    import java.net.InetSocketAddress;
    import java.net.ServerSocket;
    import java.net.Socket;

    /**
     * 服务器端
     * @author MOTUI
     *
     */
    public class BIOServerSocket {

        public static void main(String[] args) throws Exception {

            //1.创建serverSocket
            ServerSocket serverSocket = new ServerSocket();

            //2.设置端口号
            serverSocket.bind(new InetSocketAddress(8989));

            System.out.println("监听端口为8989的服务器");

            //3.获取报文
            Socket socket = serverSocket.accept();

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
            socket.close();
        }
    }
