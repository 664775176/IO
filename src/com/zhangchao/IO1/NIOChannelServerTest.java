package com.zhangchao.IO1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class NIOChannelServerTest {
    public static void main(String args[]) throws  Exception{
        new NIOChannelServerTest().server();
    }

    public void server() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select() > 0) {
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                if(key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int length = 0 ;
                    while((length = socketChannel.read(buffer)) != -1) {
                        buffer.flip();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread() + new String(buffer.array(), 0, length));
                        buffer.clear();
                    }
                    socketChannel.close();
                }
                keys.remove();
            }
        }
        serverSocketChannel.close();
    }
}
