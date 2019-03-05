package com.zhangchao.IO1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServer {
    public static void main(String args[]) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ServerSocket serverSocket = ssc.socket();
            Selector selector = Selector.open();
            //绑定要监听的端口
            serverSocket.bind(new InetSocketAddress(8080));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_READ);
            try {
                StringBuffer str = new StringBuffer();
                char[] buf = new char[1024];
                FileReader f = new FileReader("file");
                while(f.read(buf)>0){
                    str.append(buf);
                }
                str.toString();
            } catch (IOException e) {}
        } catch(Exception e) {

        }

    }
}
