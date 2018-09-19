package com.deadLock.demo;

/**
 * 获取对象锁的线程0
 *
 * @author sunchao
 * @create 2018/6/20
 */


public class Thread0 extends Thread{

    private DeadLock dl;

    public Thread0(DeadLock dl)
    {
        this.dl = dl;
    }

    @Override
    public void run()
    {
        try
        {
            dl.leftRight();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
