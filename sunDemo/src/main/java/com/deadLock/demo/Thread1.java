package com.deadLock.demo;

/**
 * 获取对象锁的线程1
 *
 * @author sunchao
 * @create 2018/6/20
 */


public class Thread1  extends Thread{
    private DeadLock dl;

    public Thread1(DeadLock dl)
    {
        this.dl = dl;
    }

    @Override
    public void run()
    {
        try
        {
            dl.rightLeft();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
