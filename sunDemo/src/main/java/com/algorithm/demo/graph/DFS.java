package com.algorithm.demo.graph;

import com.algorithm.demo.graph.model.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 *
 * @author sunchao
 * @create 2018/10/3
 *
 * @description
 * 1、利用栈实现
 * 2、从源节点开始把节点按照深度放入栈，然后弹出
 * 3、每弹出一个结点，把该节点下一个没进栈的邻节点放入栈
 * 4、直到栈变空
 *
 */


public class DFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

}
