package com.algorithm.demo;

/**
 * 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手机没牌，
 *  最后桌子上的牌是从1到n有序，设计程序，输入n，输出牌堆的顺序数组
 *
 * @author sunchao
 * @create 2018/7/17
 */


public class changeIndexAndValue {

    public static void algorithm(int n)
    {
        int a[] = new int[n];
        int b[] = new int[n];
        //新牌堆顶数组索引
        int t=n-1;
        //原牌堆顶数组索引
        int u=0;
        //原牌堆底数组索引，为了实现循环数组
        int m=0;
        //给每个原牌堆的牌打上标记
        for(int k=0;k<n;k++)
        {
            a[k]=k+1;
        }
        //共l个步骤
        for(int l=0;l<n;l++)
        {
            //将当前原牌堆顶的牌放入新牌堆顶
            b[t]= a[u];
            //新牌堆顶上移
            t--;
            //将当前原牌堆顶的牌放入原牌堆底，利用循环数组,节省空间。
            a[m]=a[(u+1)%n];
            m++;
            u=(u+2)%n;
        }
        //按顺序输出新牌堆里，原牌堆的标记，同时计算出原牌堆对应的数值
        for(int h=0;h<n;h++)
        {
            System.out.print(b[h]);
            a[b[h]-1]= h+1;
        }
        System.out.println();
        for(int p=0;p<n;p++)
        {
            System.out.print(a[p]);
        }
    }
    public static void main(String[] args) {
        changeIndexAndValue.algorithm(5);
    }

}
