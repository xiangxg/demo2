package com.example.demo;

/**
 * Created by think on 2018/5/3.
 */
public interface Stack<E> {

    void push(E e);

    E  pop();

    E peek();

    boolean isEmpty();

    int getSize();

}
