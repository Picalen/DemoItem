package com.algorithm.demo.binaryTree;

/**
 * 折纸问题  --- 二叉树
 *
 * @author sunchao
 * @create 2018/10/1
 *
 * @description
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折一次，压出折痕后展开。此时折痕是凹下去的，
 * 即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕。
 * 从上到下依次为下折痕，下折痕，上折痕。给定一个输入参数N，代表纸条都从下边向上边对折N次，请从上到下
 * 打印所有折痕的方向。
 * 例如：N=1时，打印：down
 * N=2时，打印：down  down up
 */


public class PaperFolding {

    /**
     * 解题思路：
     * 从折n下，有2的n次方-1道折痕，可以想到可能属于二叉树的结构
     * 综合前两次折痕的顺序，大概就是
     *              下
     *         下        上
     *      下    上  下     上
     *
     *  这样的二叉树，然后考虑按照中序遍历打印二叉树
     *  左-中-右 的顺序打印即可
     *
     * */

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    /**
     * 先打印左边（下），再打印右边（上）
     * N为层数
     *
     * */
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "down " : "up ");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);

    }

}
