package com.zhangchao.IO2;

    import java.io.BufferedReader;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.io.PrintWriter;
    import java.net.InetSocketAddress;
    import java.net.Socket;

    import static sun.misc.Version.println;

/**
     * 客户端
     * @author MOTUI
     *
     */
    public class BIOClientSocket {

        public static void main(String[] args) throws Exception {

            //1.创建Socket
            Socket socket = new Socket();

            //2.连接服务器
            socket.connect(new InetSocketAddress("127.0.0.1",8989));
            socket.setSoTimeout(100000);
//            //b.获得服务器的回应
//            InputStream is = socket.getInputStream();
//            //字符流和字节流的转换
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//
//            //存储读取的数据
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//           // socket.shutdownInput();
//            //读取数据
//            while((line = br.readLine()) != null){
//                //将数据存储在StringBuilder中
//                sb.append(line);
//            }
//            socket.shutdownInput();
//            //打印服务器回应数据
//            System.out.println(sb.toString());
//            socket.shutdownInput();

            //a.发送数据到服务器
            OutputStream os = socket.getOutputStream();
            //获得输出流
            PrintWriter pw = new PrintWriter(os);
            pw.write("这是客户端数据");
            //将数据发送
            pw.flush();
            //告知服务器已经到了流的结尾
            System.out.println("socket.isClosed:" + socket.isClosed());
            System.out.println("socket.isInputShutdown:" + socket.isInputShutdown());
            System.out.println("socket.isOutputShutdown:" + socket.isOutputShutdown());
            System.out.println("socket.isBound:" + socket.isBound());
            System.out.println("socket.isConnected:" + socket.isConnected());
            //关闭流
//            is.close();
            os.close();
//            br.close();
            pw.close();
            socket.close();
            System.out.println("end");
        }
    }