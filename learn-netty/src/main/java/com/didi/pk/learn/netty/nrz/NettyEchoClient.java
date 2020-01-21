package com.didi.pk.learn.netty.nrz;

import com.didi.pk.learn.netty.EchoClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author pengkai
 * @date 2019-11-09
 */
public class NettyEchoClient {
    private int serverPort;
    private String serverIp;
    Bootstrap b = new Bootstrap();

    public NettyEchoClient(String ip, int port) {
        this.serverIp = ip;
        this.serverPort = port;
    }

    public void runClient() {
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {
            b.group(workerLoopGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(serverIp, serverPort))
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyEchoClientHandler());
                        }
                    });
            ChannelFuture f = b.connect();
            f.addListener(channelFuture -> {
                if (channelFuture.isSuccess()) {
                    System.out.println("EchoClient 客户端连接成功");
                } else {
                    System.out.println("EchoClient 客户端连接失败");
                }
            });
            f.sync();
            Channel channel = f.channel();
            for(int i = 0;i<1000;i++) {
                byte[] bytes = "亲爱的".getBytes("utf-8");
                ByteBuf buffer = channel.alloc().buffer();
                buffer.writeBytes(bytes);
                channel.writeAndFlush(buffer);
            }

        } catch (InterruptedException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            workerLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyEchoClient("localhost", 9988).runClient();
    }
}
