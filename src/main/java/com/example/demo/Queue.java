package com.example.demo;

/**
 * Created by think on 2018/5/3.
 */
public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    int getSize();
    boolean isEmpty();
    E getFront();
}
