package com.thread.demo;

/**
 * Object.lock() 方法
 *
 * @author sunchao
 * @create 2018/9/19
 */


public class LockDemo {

    /**
    * 实现打印固定顺序 A 1, B 1, B 2, B 3, A 2, A 3
     * 通过Object.wait() 和 Object.notify()来实现
    * */
    private static void main(String[] args) {
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        A.start();
        B.start();
    }
}
