package com.didi.pk.learn.java;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author pengkai
 * @date 2019-09-11
 */
public class CharTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "a";

        System.out.println(Arrays.toString(str.getBytes()));
    }
}
