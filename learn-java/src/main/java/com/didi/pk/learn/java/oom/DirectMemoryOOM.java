package com.didi.pk.learn.java.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * @author pengkai
 * @date 2019-09-21
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024 * 20;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
//            unsafe.allocateMemory(_1MB);
            ByteBuffer.allocateDirect(_1MB);
        }
    }
}
