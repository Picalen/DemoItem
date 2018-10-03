package com.algorithm.demo.mix;

/**
 * 在数组中寻找一个局部最小位置
 *
 * @author sunchao
 * @create 2018/10/2
 *
 * @description
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]时，
 * 那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]时，那么arr[N-1]为局部最小；如果0<i<N-1,存在
 * arr[i-1]<arr[i]<arr[i+1]，那么arr[i] 是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不想等，写一个函数，只需要返回arr中任意一个局部最小
 * 出现的位置即可。
 */


public class FindOneLessValueIndex {
    /**
     *
     * 返回任一位置，先考虑第一个和最后一个。若两个都不是，则说明数组中必有一个局部最小(两端向中间的趋势均向下变小)
     * 取中间值，判断其是否为局部最小，若不是，再找比中间值大的那个数，与一端进行二分查找
     *
     * */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            // no exist
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }

}
