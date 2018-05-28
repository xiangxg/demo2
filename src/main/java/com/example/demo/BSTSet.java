package com.example.demo;

/**
 * Created by think on 2018/5/24.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST2<E> bst;

    public BSTSet() {
        bst = new BST2<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
