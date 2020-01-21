package com.didi.pk.learn.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author pengkai
 * @date 2019-09-30
 */
public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress("www.baidu.com", 80))
                .handler(new ChannelHandler() {
                    @Override
                    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

                    }

                    @Override
                    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

                    }
                });

        ChannelFuture channelFuture = b.connect();
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    System.out.println("haha");
                    ByteBuf buffer = Unpooled.copiedBuffer("hello", Charset.defaultCharset());
                    ChannelFuture wf = channelFuture.channel().writeAndFlush(buffer);
                } else {
                    channelFuture.cause().printStackTrace();
                }
            }
        });
        Thread.sleep(10000);
    }
}
