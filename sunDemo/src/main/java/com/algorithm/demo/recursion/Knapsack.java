package com.algorithm.demo.recursion;

/**
 *
 * @author sc
 * @date 2018-10-8$
 * @description 类似背包问题
 *
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的 重量，v[i]表示第i件商品的价值。
 * 再给定一个整数bag，要求你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件下，你能获得的最大价值。
 *
 */
public class Knapsack {

    public static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, 0, 0, bag);
    }

    /**
     * 暴力递归，取得重量bag下的最大价值
     *
     * */
    public static int process1(int[] c, int[] p, int i, int cost, int bag) {
        if (cost > bag) {
            return Integer.MIN_VALUE;
        }
        if (i == c.length) {
            return 0;
        }
        return Math.max(process1(c, p, i + 1, cost, bag), p[i] + process1(c, p, i + 1, cost + c[i], bag));
    }

    /**
     * 凡是子情况不依赖父情况选择的递归，都可以改成动态规划问题
     * 该问题的每个情况（i,w），在下一个情况中，选择加 /不加 该位置重量c[i]的最大值
     *
     * */
    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(c, p, bag));
        System.out.println(maxValue2(c, p, bag));
    }
}
