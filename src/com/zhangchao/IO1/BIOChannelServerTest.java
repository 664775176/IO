package com.zhangchao.IO1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BIOChannelServerTest {
    public static void main(String args[]) throws  Exception{
        new BIOChannelServerTest().server();
        //new BIOChannelTest().client();
    }

    public void server() throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8080));
        FileChannel fileChannel = FileChannel.open(Paths.get("data.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        SocketChannel accept = socketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int length = 0;
        while((length = accept.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, length));
            buffer.clear();
        }
        System.out.println("server print ...");
        buffer.put("server success".getBytes());
        buffer.flip();
        accept.write(buffer);

        accept.close();
        fileChannel.close();
        socketChannel.close();
    }
}
