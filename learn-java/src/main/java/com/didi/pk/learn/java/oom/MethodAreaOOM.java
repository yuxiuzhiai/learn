package com.didi.pk.learn.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengkai
 * @date 2019-09-21
 */
public class MethodAreaOOM {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Object> list = new ArrayList<>();
        while(true) {
            ClassLoader cl = new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    return super.loadClass(name,false);
                }
            };
            Class cls =  cl.loadClass("java.lang.String");
            list.add(cls);
        }
    }
}
