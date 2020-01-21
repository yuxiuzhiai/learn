package com.didi.pk.learn.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengkai
 * @date 2019-09-21
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        while(true){
            list.add(new int[1024]);
        }
    }

}
