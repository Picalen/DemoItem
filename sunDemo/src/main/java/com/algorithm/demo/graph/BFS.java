package com.algorithm.demo.graph;

import com.algorithm.demo.graph.model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先遍历Node
 *
 * @author sunchao
 * @create 2018/10/3
 *
 * @description
 * 从一个结点开始，一层一层往下打印对应的Node
 * 1、利用队列实现
 * 2、从源节点开始依次按照宽度进队列，然后弹出
 * 3、每弹出一个点，把该节点所有没进过队列的邻结点放入队列
 * 4、直到队列变空
 *
 */


public class BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        /**
         * HashSet 避免重复遍历
         * */
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
