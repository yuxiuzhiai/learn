package com.didi.pk.learn.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pengkai
 * @date 2019-10-29
 */
public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = -1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == -1){
                    continue;
                }
                if(i==0&&j==0){
                    dp[i][j] = 1;
                }else if(j==0){
                    if(dp[i-1][j] == -1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }

                }else if(i==0){
                    if(dp[i][j-1] == -1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }else{
                    if(dp[i-1][j] == -1 && dp[i][j-1] == -1){
                        dp[i][j] = 0;
                    }else if(dp[i-1][j] == -1){
                        dp[i][j] = dp[i][j-1];
                    }else if(dp[i][j-1] == -1){
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1] == -1?0:dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] prices = {{0,0}};
        int max = uniquePathsWithObstacles(prices);
        System.out.println(max);
    }

}
