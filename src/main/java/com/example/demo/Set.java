package com.example.demo;

/**
 * Created by think on 2018/5/24.
 */
public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
