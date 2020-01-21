package com.didi.pk.learn.alg.algs4th.ch01;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class UF {

    private int[] id;
    private int count;

    public UF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    public int find(int p) {
        return id[p];
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
