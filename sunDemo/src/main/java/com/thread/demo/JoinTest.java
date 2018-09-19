package com.thread.demo;

/**
 * thread.join()方法
 *
 * @author sunchao
 * @create 2018/9/19
 */


public class JoinTest {

    public static void main(String args[]) {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");

                /**
                * A.join() 方法会让 B线程  一直等待直到 A 运行完毕
                * A.join(100) 指会让B线程等待100ms
                * A.join(0) 等同于A.join()
                * */
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
    }

    private static void printNumber(String threadName) {
        int i=0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }
}
