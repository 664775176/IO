package com.zhangchao.IO1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOChannelClientTest {
    public static void main(String args[]) throws  Exception{
        new NIOChannelClientTest().client();
        new NIOChannelClientTest().client();
    }

    public void client()throws  Exception{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("你可理论上的。。。".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.close();
    }
}
