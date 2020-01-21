package com.didi.pk.learn.java.io.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author pengkai
 * @date 2019-11-07
 */
public class EchoHandler implements Runnable {

    final SocketChannel channel;
    final SelectionKey sk;
    final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    int state = RECEIVING;
    static final int RECEIVING = 0;
    static final int SENDING = 1;

    public EchoHandler(Selector selector,SocketChannel channel) throws IOException {
        this.channel = channel;
        channel.configureBlocking(false);
        sk = channel.register(selector,0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try{
            if(state == SENDING){
                channel.write(byteBuffer);
                byteBuffer.clear();
                sk.interestOps(SelectionKey.OP_READ);
                state = RECEIVING;
            }else if(state == RECEIVING){
                int length = 0;
                while ((length = channel.read(byteBuffer)) > 0){
                    System.out.println(new String(byteBuffer.array(),0,length));
                }
                byteBuffer.flip();
                sk.interestOps(SelectionKey.OP_WRITE);
                state = SENDING;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
