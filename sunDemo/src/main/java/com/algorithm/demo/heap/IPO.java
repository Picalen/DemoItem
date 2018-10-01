package com.algorithm.demo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 贪心算法 - 最大收益问题
 *
 * @author sunchao
 * @create 2018/10/1
 *
 * @description
 * 输入：
 * 参数1：正数数组costs；参数2：正数数组profits；参数3：正数k；参数4：正数m。
 * 其中，costs[i] 表示i号项目的花费，profits[i] 表示i号项目在扣除花费后还能挣到的钱（利润）
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你的初始资金
 * 说明：当你做完一个项目，马上获得的收益，可以支持你去做下一个项目
 * 输出：你的最大收益
 */


public class IPO {

    /**
     * 解题思路：
     * 先考虑能做的项目，然后在其中挑利润最大的
     * 先把所有的花费-利润 按照花费初始资金放入小根堆，然后一个一个弹出到按利润排序的大根堆，直到资金达到初始资金上限
     * 弹出大根堆 堆顶项目，做完后增加初始资金，继续把小根堆项目弹入大根堆，再根据利润最大弹出
     * 直到达到项目总数k
     *
     * */

    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }

}
