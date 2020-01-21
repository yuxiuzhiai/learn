package com.didi.pk.learn.netty.nrz;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pengkai
 * @date 2019-12-29
 */
public class MultiThreadEchoHandler implements Runnable {
    private final SocketChannel channel;
    private SelectionKey sk;

    static ExecutorService pool = Executors.newFixedThreadPool(4);

    public MultiThreadEchoHandler(Selector selector, SocketChannel channel) {
        this.channel = channel;
        try {
            channel.configureBlocking(false);
            sk = channel.register(selector, 0);
            sk.attach(this);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        pool.execute(() -> {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            try {
                channel.read(byteBuffer);
                byteBuffer.flip();
                channel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
