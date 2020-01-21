package com.didi.pk.learn.alg.dp;

/**
 * @author pengkai
 * @date 2019-12-21
 */
public class MinPathProblem {

    private static int[][] dp;

    public static int minPath(int[][] matrix) {
        dp = new int[matrix.length][matrix.length];
        dp[0][0] = matrix[0][0];
        return minPath0(matrix, matrix.length - 1, matrix.length - 1);
    }

    private static int minPath0(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if(i > 0){
             minLeft = minPath0(matrix, i - 1, j);
        }

        int minUp = Integer.MAX_VALUE;
        if(j>0) {
            minUp = minPath0(matrix, i, j - 1);
        }
        int minPath = matrix[i][j] + Math.min(minLeft, minUp);
        dp[i][j] = minPath;
        return minPath;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        int minPath = minPath(matrix);
        System.out.println(minPath);
    }
}
