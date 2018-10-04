package com.algorithm.demo.graph;

import com.algorithm.demo.graph.model.Graph;
import com.algorithm.demo.graph.model.Node;

import java.util.*;

/**
 * 有向图拓扑排序
 *
 * @author sunchao
 * @create 2018/10/4
 */


public class TopologySort {
    // directed graph and no loop
    /**
     * 必须是有向图且无环
     * 根据入度为0，一层层放入队列吐出，吐完把吐出节点的下一个节点入度减1
     * */
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
