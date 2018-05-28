package com.example.demo;

/**
 * Created by think on 2018/5/26.
 */
public class BSTMap<K extends Comparable,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null){
            size ++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else
            node.value = value;
        return node;
    }

    private Node getNode(Node node,K key){
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else if (key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }
        return node;
    }

    /**
     * 获取以node为根的二分搜索树中最小的节点
     * @param node
     * @return
     */
    private Node miniNode(Node node){
        if (node == null)
            return null;
        if (node .left == null)
            return node;
        else
            return miniNode(node.left);
    }

    /**
     * 删除以node为根的二分搜索树中最小的节点
     * 并返回删除后的根节点
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if (node == null)
            return null;
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }



    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) <0 ){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key) <0 ){
            node.right = remove(node.right,key);
            return node;
        }else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //获取node右子树中最小的节点
            Node successor = miniNode(node.right);
            //删除node右子树中的最小节点，并返回删除后的根节点
            Node rightNode = removeMin(node.right);
            successor.right = rightNode;
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node != null)
            node.value = newValue;
        else
            throw new IllegalArgumentException("key is not exits!");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
