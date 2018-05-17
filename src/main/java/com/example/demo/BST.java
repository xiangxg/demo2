package com.example.demo;

/**
 * Created by think on 2018/5/15.
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }

    private int size;
    private Node root;

    public BST(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e){
        if (root == null){
            root = new Node(e);
            size ++;
        }

        add(root,e);
    }

    private void add(Node node, E e) {
        if (node.e.equals(e))
            return;
        if (node.e.compareTo(e)< 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }else if(node.e.compareTo(e)> 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }

        if (node.e.compareTo(e)<0){
            add(node.left,e);
        }else
            add(node.right,e);
    }


}
