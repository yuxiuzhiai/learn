package com.didi.pk.learn.netty;

import com.didi.pk.learn.netty.nrz2.Byte2IntegerDecoder;
import com.didi.pk.learn.netty.nrz2.IntegerProcessHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

/**
 * @author pengkai
 * @date 2019-11-09
 */
public class Byte2IntegerDecoderTest {
    @Test
    public void func() throws InterruptedException {
        ChannelInitializer<EmbeddedChannel> ci = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel channel) throws Exception {
                channel.pipeline().addLast(new Byte2IntegerDecoder());
                channel.pipeline().addLast(new IntegerProcessHandler());
            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(ci);
        for (int i = 0; i < 100; i++) {
            ByteBuf buf = Unpooled.buffer();
            buf.writeInt(i);
            channel.writeInbound(buf);
        }
        Thread.sleep(10000);
    }
}
