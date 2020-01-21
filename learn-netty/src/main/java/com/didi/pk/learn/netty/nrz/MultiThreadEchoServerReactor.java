package com.didi.pk.learn.netty.nrz;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengkai
 * @date 2019-12-29
 */
public class MultiThreadEchoServerReactor {
    private String ip;
    private int port;
    private ServerSocketChannel serverSocketChannel;
    AtomicInteger next = new AtomicInteger(0);
    Selector[] selectors = new Selector[2];
    SubReactor[] subReactors;

    public MultiThreadEchoServerReactor(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(ip, port);
        serverSocketChannel.socket().bind(address);
        serverSocketChannel.configureBlocking(false);

        SelectionKey sk = serverSocketChannel.register(selectors[0], SelectionKey.OP_ACCEPT);
        sk.attach(new AcceptorHandler());

        SubReactor subReactor1 = new SubReactor(selectors[0]);
        SubReactor subReactor2 = new SubReactor(selectors[1]);
        subReactors = new SubReactor[]{subReactor1, subReactor2};

    }

    public void startService() {
        new Thread(subReactors[0]).start();
        new Thread(subReactors[1]).start();
    }

    private static class SubReactor implements Runnable {

        private final Selector selector;

        public SubReactor(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set<SelectionKey> keySet = selector.selectedKeys();
                    for (SelectionKey sk : keySet) {
                        dispatch(sk);
                    }
                    keySet.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void dispatch(SelectionKey sk) {
            Runnable handler = (Runnable) sk.attachment();
            if (handler != null) {
                handler.run();
            }
        }
    }

    private class AcceptorHandler implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new MultiThreadEchoHandler(selectors[next.get()], socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (next.incrementAndGet() == selectors.length) {
                next.set(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MultiThreadEchoServerReactor serverReactor = new MultiThreadEchoServerReactor("127.0.0.1", 9988);
        serverReactor.startService();
    }
}
