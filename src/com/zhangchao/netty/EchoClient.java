package com.zhangchao.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
    private final int port;
    private final String ip;

    public EchoClient(String ip,int port) {
        this.ip = ip;
        this.port = port;
    }

    public static void main(String []args) throws Exception{
        String ip = "localhost";
        int port = 8080;
        new EchoClient(ip, port).start();
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
            .remoteAddress(new InetSocketAddress(ip, port))
            .handler(new ChannelInitializer<SocketChannel>(){
                public void initChannel(SocketChannel ch) throws Exception {
                    new EchoClientHandler();
                }
            });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }


    }
}
