package com.didi.pk.learn.java.oom;

/**
 * @author pengkai
 * @date 2019-09-21
 */
public class InternTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
