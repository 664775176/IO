package com.zhangchao.IO1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NIOClient {

    public void addClient(){
        try {
            SocketChannel channel = SocketChannel.open();
            //设置非阻塞
            channel.configureBlocking(false);
            //对于非阻塞模式，立刻返回false，表示连接正在建立中
            channel.connect(new InetSocketAddress("127.0.0.1", 8080));
            Selector selector = Selector.open();
            //向channel注册selector以及感兴趣的连接事件
            channel.register(selector, SelectionKey.OP_CONNECT);
            //阻塞至有感兴趣的IO事件发生，或者到达超时事件，如果希望一直等到有感兴趣的IO事件发生，可调用
            //无参数的select方法，如果希望
            // 不阻塞直接返回目前是否有感兴趣的事件发生，可调用selectNow方法。
            int nKeys = selector.select(1*1000);
            //如果nKeys大于0，说明有感兴趣的IO事件发生
            SelectionKey sKey = null;
            if(nKeys > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                for(SelectionKey key: keys) {
                    //对于发生连接事件
                    if(key.isConnectable()){
                        SocketChannel sc = (SocketChannel)key.channel();
                        sc.configureBlocking(false);
                        //注册感兴趣低的IO读事件，通常不直接注册写事件，在发送缓冲区未满的情况下，一直是可写的，
                        //因此如注册了写事件，而又不用写数据，很容易造成cpu消耗100%的现象
                        sKey = sc.register(selector, SelectionKey.OP_READ);
                        //完成连接的建立
                        sc.finishConnect();
                    } else if(key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel sc = (SocketChannel)key.channel();
                        int readBytes = 0;
                        try {
                            int ret = 0;
                            try{
                                //读取目前可读的流，sc.read返回的成功复制到bytebuffer中的字节，
                                //此步为阻塞操作，值可能为0；当已经是流的结尾时，返回-1
                                while((ret=sc.read(buffer)) > 0) {
                                    readBytes += ret;
                                }
                            } finally {
                                buffer.flip();
                            }
                        }finally {
                            if(buffer != null){
                                buffer.clear();
                            }
                        }
                    } else if(key.isWritable()) {
                        //取消对OP_WRITE事件的注册
                        key.interestOps(key.interestOps() & (~SelectionKey.OP_WRITE));
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel sc = (SocketChannel)key.channel();
                        //此步为阻塞操作，直到写入操作系统发送缓冲区或网络IO出现异常，返回的为成功
                        //写入字节数，当操作系统的发送缓冲区已满，此处会返回0
                        int writeennedSize = sc.write(buffer);
                        //如未写入，则继续注册感兴趣的OP_WRITE事件
                        if(writeennedSize == 0) {
                            key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                        }
                    }
                }
                selector.selectedKeys().clear();

            }
        } catch (Exception e) {

        }
    }
}

