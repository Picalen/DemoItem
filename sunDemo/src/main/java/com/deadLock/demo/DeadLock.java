package com.deadLock.demo;

/**
 * 死锁对象类
 *
 * @author sunchao
 * @create 2018/6/20
 */


public class DeadLock {

    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() throws Exception
    {
        synchronized (left)
        {
            //sleep(2000)是为了防止一个线程迅速连续获得两个锁了，使得测试效果失败
            Thread.sleep(2000);
            synchronized (right)
            {
                System.out.println("leftRight end!");
            }
        }
    }

    public void rightLeft() throws Exception
    {
        synchronized (right)
        {
            Thread.sleep(2000);
            synchronized (left)
            {
                System.out.println("rightLeft end!");
            }
        }
    }
}
