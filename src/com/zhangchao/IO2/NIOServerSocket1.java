package com.zhangchao.IO2;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIO 服务器端
 * 
 * @author MOTUI
 * 
 */
public class NIOServerSocket1 {

    public static void main(String[] args) throws Exception {

    // 1.创建ServerSocketChannel
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    // 2.绑定端口
    serverSocketChannel.bind(new InetSocketAddress(8989));
    // 3.设置为非阻塞
    serverSocketChannel.configureBlocking(false);
    ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
           // System.out.println("服务器端：正在监听8989端口");
            // 6.获取可用I/O通道,获得有多少可用的通道
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) { // 判断是否存在可用的通道
                executorService.submit(new Runnable() {
                    //3.获取报文
                    @Override
                    public void run() {
                        try {
                            //打印当前线程ID
                            System.out.println("当前线程ID："+Thread.currentThread().getId());

                            // I/O读数据操作
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            int len = 0;
                            while (true) {
                                buffer.clear();
                                len = socketChannel.read(buffer);
                                if (len == -1) break;
                                buffer.flip();
                                while (buffer.hasRemaining()) {
                                    baos.write(buffer.get());
                                }
                            }
                            System.out.println(Thread.currentThread()+"服务器端接收到的数据："+ new String(baos.toByteArray()));
                            //socketChannel.shutdownInput();
                            // 写操作
                            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
                            String message = "你好，我好，大家好！！";
                            buffer1.put(message.getBytes());
                            buffer1.flip();
                            socketChannel.write(buffer1);
                            socketChannel.close();
                            System.out.println(Thread.currentThread()+"服务器端发送的数据："+ message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                socketChannel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }
}
