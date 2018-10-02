package com.algorithm.demo.binaryTree;

/**
 * 寻找后继节点
 *
 * @author sunchao
 * @create 2018/10/2
 *
 * @description
 * 现有一种新的二叉树节点类型如下：
 *  public class Node{
 *      public int value;
 *      public Node left;
 *      public Node right;
 *      public Node parent;
 *
 *      public Node(int data){
 *          this.value = data;
 *      }
 *  }
 *
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针，假设有一颗Node类型的节点组成的二叉树，
 * 树中每个节点的parent都正确的指向自己的父节点，头节点的parent指向null。只给一个在二叉树中的某个
 * 节点Node，请实现返回Node的后继节点的函数。
 * 在二叉树的中序遍历的序列中，node的下一个节点叫做node的后继节点。
 *
 */

public class DescendantNode {
    /**
     * 按照题意，最粗暴的解题思路是把node按照中序遍历（左-中-右）实现排序，再根据node对比遍历该序列，得出node的下一个节点返回
     * 当然，这样的时间复杂度非常大，明显不是最优解。
     * 所以应该考虑按照不同情况总结对应的后继节点取法，然后实现：
     * (1)当该节点node的右节点不为空的时候，应该取得其右节点中的最左节点返回
     * (2)当该节点node的右节点为空的时候，应该判断该node是否为其父节点的左孩子，若是，则返回父节点
     * (3)当该节点node的右节点为空的时候，判断该node是其父节点的右孩子，那么应该继续往上查询，直到找到当前节点为
     *     其上一节点的左孩子的情况，然后打印该上一节点。
     * (4)当然，需要考虑最后一个节点，往上找不到对应(4)中的情况，所以要加一个null的判断。
     * */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getNextNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.right;
        // 10's next is null
        System.out.println(test.value + " next: " + getNextNode(test));
    }

}
