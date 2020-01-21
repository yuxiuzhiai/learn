package com.didi.pk.learn.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengkai
 * @date 2019-09-20
 */
public class Test {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String s = String.valueOf(i);
            A a = new A();
            list.add(s);
        }

        System.out.println(list.size());

    }
}

class A {
    byte[] bytes = new byte[1024];

    A() {
    }
}