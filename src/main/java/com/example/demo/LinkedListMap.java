package com.example.demo;

/**
 * Created by think on 2018/5/24.
 */
public class LinkedListMap<K,V> implements Map<K,V> {
    class Node{
        public K key;
        public V value;
        Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key,V value){
           this(key,value,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }
    }

    private Node dumyHead;
    private int size;

    private Node getNode(K key){
        Node cur = dumyHead.next;
        while (cur != null){
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return  null;
    }
    public LinkedListMap() {
        dumyHead = new Node();
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            dumyHead.next = new Node(key,value,dumyHead.next);
        }else
            node.value = value;
    }

    @Override
    public V remove(K key) {
        Node pre = dumyHead;
        while (pre.next != null){
            if (pre.next.key.equals(key))
                break;
            pre = pre.next;
        }
        if (pre.next != null){
            Node remNode = pre.next;
            pre.next = pre.next.next;
            remNode.next = null;
            size--;
            return remNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key+"does not exist");
        node.value = newValue;
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
