package com.example.demo;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by think on 2018/5/15.
 */
public class BST2<E extends Comparable<E>> {
    private class Node {
        E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node root;


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) < 0) {
            contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            contains(node.right, e);
        }
        return true;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历非递归写法
     */
    public void preOrderNC() {
        if (root == null)
            return;
        java.util.Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.e);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    /**
     * 获取最小node
     *
     * @return
     */
    public Node getMinNode() {
        return getMinNode(root);
    }

    /**
     * 获取最小node,非递归
     *
     * @return
     */
    public Node getMinNodeNC() {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }


    private Node getMinNode(Node node) {
        if (node.left == null)
            return node;
        return getMinNode(node.left);
    }

    /**
     * 获取最小node
     *
     * @return
     */
    public Node getMaxNode() {
        return getMaxNode(root);
    }

    private Node getMaxNode(Node node) {
        if (node.right == null)
            return node;
        return getMaxNode(node.right);
    }

    /**
     * 删除最小节点
     *
     * @return
     */
    public Node delMinNode() {
        return delMinNode(root);
    }

    /**
     * 删除最小节点,非递归
     *
     * @return
     */
    public Node delMinNodeNC() {
        if (root.left == null)
            return root.right;
        Node pre = null;
        Node cur = root;
        while (cur.left != null){
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;
        return cur;
    }

    private Node delMinNode(Node node) {
        if (node.left == null)
            return node.right;
        node.left = delMinNode(node.left);
        return node;
    }

    /**
     * 删除最小节点
     *
     * @return
     */
    public Node delMaxNode() {
        return delMaxNode(root);
    }

    private Node delMaxNode(Node node) {
        if (node.right == null)
            return node.left;
        node.right = delMaxNode(node.right);
        return node;
    }

    public static void main(String[] args) {

        BST2<Integer> bst = new BST2<>();
        int[] nums = {5, 3, 6, 8, 4, 2, 7};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.levelOrder();
        System.out.println();
        bst.delMinNodeNC();
        bst.delMinNodeNC();
        System.out.println();
        bst.levelOrder();
        System.out.println();


    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

}
