package com.didi.pk.learn.alg.dp;

/**
 * @author pengkai
 * @date 2019-12-21
 */
public class BagProblem {
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] dp = new boolean[n][w + 1];
        dp[0][0] = true;
        if (weight[0] < w) {
            dp[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            //放入低i个物品
            for (int j = 0; j <= w - weight[i]; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j + weight[i]] = true;
                }
            }
            //不放入低i个物品
            for (int j = 0; j <= w; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = w; i > 0; i--) {
            if (dp[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3, 2};
        int max = knapsack(weight, 6, 100);
        System.out.println(max);
    }
}
