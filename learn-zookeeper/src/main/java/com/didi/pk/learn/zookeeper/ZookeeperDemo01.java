package com.didi.pk.learn.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.proto.*;

import java.io.IOException;

/**
 * @author pengkai
 * @date 2019-11-10
 */
public class ZookeeperDemo01 implements Watcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperDemo01());
        System.out.println(zooKeeper.getState());

        Thread.sleep(3000);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("received event:" + watchedEvent);
    }
}