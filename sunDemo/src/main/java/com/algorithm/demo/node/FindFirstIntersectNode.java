package com.algorithm.demo.node;

/**
 *
 * @author sc
 * @date 2018-09-26
 * @description 两个单链表相交的问题
 * 在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点head1和head2，这两个链表
 * 可能相交，也可能不相交。请实现一个函数，如果两个链表相交，请返回相交的第一个交点，如果
 * 不相交，返回null即可。
 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到 O(1)
 *
 */
public class FindFirstIntersectNode {

    /**
     * 链表单个元素定义
     * */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 此方法用来获取一个链表是否有环，有环返回入环第一个点，否则返回null
     * */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast

        /**
         * 快慢指针法，快指针走两步，满指针走一步，若相遇，则一定有环
         * 此时，快指针从头开始，也走一步，相遇时即入环节点
         * */
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 处理两个均是无环链表的相交问题
     * */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        /**
         * 若两无环链表结尾不是同一个节点，则不可能相交
         * */
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        /**
         * 两个无环链表，长的先走差值步数，然后在相交处相遇
         * */
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 处理两个均是有环链表的相交问题
     * */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        /**
         * 如果两个环节点相同，则参考上面无环链表，把环节点作为最终节点
         * */
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            /**
             * 环节点不同的话，则从一个点继续往下，若遇到另外一个，则说明两链表相交，返回任意环节点
             * 若返回原点，没遇到另外一个，则返回null
             * */

            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

}
