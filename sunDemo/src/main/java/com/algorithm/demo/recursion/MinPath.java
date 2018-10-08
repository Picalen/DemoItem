package com.algorithm.demo.recursion;

import java.util.HashMap;

/**
 * 最小路径问题
 *
 * @author sunchao
 * @date  2018/10/4
 *
 * 解决方法有两种：
 * (1)暴力递归
 *    1、把问题转化为规模缩小了的同类问题的子问题
 *    2、有明确的不需要继续进行递归的条件(base case)
 *    3、有当得到了子问题的结果之后的决策过程
 *    4、不记录每一个子问题的解
 *
 * (2)动态规划
 *   1、从暴力递归中引申
 *   2、将每一个子问题的解记录下来，避免重复计算
 *   3、把暴力递归的过程，抽象成了状态表达
 *   4、并且存在化简状态表达，使其更加简洁的可能
 *
 */


public class MinPath {


    public static int minPath1(int[][] matrix) {
        //return process1(matrix, matrix.length - 1, matrix[0].length - 1);
        return new MinPath().process2(matrix, 0, 0);
    }

    /**
     * 暴力递归
     *
     * */
    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

    /**
     * 粗略动态规划
     * 把已经走过的点的路程，在map中存起来
     *
     * */
    HashMap<String,Integer> cache = new HashMap<>();
    public  int process2(int[][] matrix, int i, int j) {
        int result ;
        if (i == matrix.length-1  && j == matrix[0].length-1) {
            result =  matrix[i][j];
        }else if (i == matrix.length-1) {
            //到最下边了
            String key = String.valueOf(i)+"_"+String.valueOf(j + 1);
            if(cache.containsKey(key)){
                result =  matrix[i][j]+cache.get(key);
            }else {
                result =  matrix[i][j]+process2(matrix,i,j+1);
            }
        }else if(j == matrix[0].length-1){
            //到最左边了
            String key = String.valueOf(i+1)+"_"+String.valueOf(j);
            if(cache.containsKey(key)){
                result =  matrix[i][j]+cache.get(key);
            }else {
                result =  matrix[i][j]+process2(matrix,i+1,j);
            }
        }else {
            int downNext ;
            String downNextKey = String.valueOf(i+1)+"_"+String.valueOf(j);
            if(cache.containsKey(downNextKey)){
                downNext = cache.get(downNextKey);
            }else {
                downNext = process2(matrix,i+1,j);
            }

            int rightNext ;
            String rightNextKey = String.valueOf(i)+"_"+String.valueOf(j+1);
            if(cache.containsKey(rightNextKey)){
                rightNext = cache.get(rightNextKey);
            }else {
                rightNext = process2(matrix,i,j+1);
            }
            result = matrix[i][j]+Math.min(downNext,rightNext);
        }
        String key =  String.valueOf(i)+"_"+String.valueOf(j);
        if(!cache.containsKey(key)){
            cache.put(key,result);
        }
        return result;
    }

    /**
     * 最优动态规划 dp过程
     * */
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        int[][] gg = generateRandomMatrix(6, 7);
        System.out.println(minPath1(gg));
        System.out.println(minPath2(gg));
    }


}
