package com.algorithm.demo.recursion;

import java.util.Stack;

/**
 * @author sc
 * @date 2018-10-10$
 * @description 逆序栈问题
 * 给定一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数，如何实现？
 *
 */
public class ReverseStackUsingRecursive {

    /**
     * 递归取得最后一个数 逆序
     * */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 递归取得栈中最后一个数，并把剩下的数据原序放置
     * */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }
}
