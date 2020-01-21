package com.didi.pk.learn.dubbo.echo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * @author pengkai
 * @date 2019-08-04
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServiceConfig<EchoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("java-echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.setInterface(EchoService.class);
        service.setRef(new EchoServiceImpl());
        service.export();
        System.out.println("java-echo-provider is running.");
        System.in.read();
    }

}
