package com.didi.pk.learn.netty.nrz;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author pengkai
 * @date 2019-11-09
 */
public class NettyEchoServer {
    private final int serverPort;
    ServerBootstrap b = new ServerBootstrap();

    public NettyEchoServer(int port){
        this.serverPort = port;
    }

    public void runServer(){
        EventLoopGroup boos = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();

        try{
            b.group(boos,worker);
            b.channel(NioServerSocketChannel.class);
            b.localAddress(serverPort);
            b.option(ChannelOption.SO_KEEPALIVE,true);
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyEchoServerHandler());
                }
            });
            ChannelFuture channelFuture = b.bind().sync();
            System.out.println("服务器启动成功,监听端口:"+channelFuture.channel().localAddress());

            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
            boos.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new NettyEchoServer(9999).runServer();
    }
}
