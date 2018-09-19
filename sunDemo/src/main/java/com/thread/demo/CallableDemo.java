package com.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable与Runnable用法区别
 * Runnable 执行完run()方法不返回结果，Callable返回(V)泛型方法
 *
 * @author sunchao
 * @create 2018/9/19
 */
public class CallableDemo {
    /**
     * 实现效果：
     * 用FutureTask配合Callable接收返回子线程结果
     * 主线程调用 futureTask.get() 方法时阻塞主线程；然后 Callable 内部开始执行，并返回运算结果；
     * 此时 futureTask.get() 得到结果，主线程恢复运行
     *
     * */
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i=0; i<=100; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
