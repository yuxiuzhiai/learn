package com.didi.pk.learn.netty.nrz2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author pengkai
 * @date 2019-11-09
 */
public class Byte2IntegerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (byteBuf.readableBytes() >= 4){
            int i = byteBuf.readInt();
            System.out.println("解码出一个整数:"+i);
            list.add(i);
        }
    }
}
