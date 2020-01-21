package com.didi.pk.learn.dubbo.echo;

/**
 * @author pengkai
 * @date 2019-08-04
 */
public class EchoServiceImpl implements EchoService {
    public String say(String msg) {
        return "hello," + msg;
    }
}
