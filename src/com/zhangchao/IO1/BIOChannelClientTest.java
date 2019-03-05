package com.zhangchao.IO1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BIOChannelClientTest {
    public static void main(String args[]) throws  Exception{
        new BIOChannelClientTest().client();
    }

    public void client()  throws  Exception{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        FileChannel fileChannel = FileChannel.open(Paths.get("utf.txt"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(fileChannel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        //这里必须shutdown写否则没办法切换到接受数据模式
        socketChannel.shutdownOutput();
        System.out.println("client waiting reading server response");
        int length = 0;
        while((length = socketChannel.read(buffer)) !=-1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, length));
            buffer.clear();
        }
        System.out.println("end....");
        fileChannel.close();
        socketChannel.close();
    }
}
