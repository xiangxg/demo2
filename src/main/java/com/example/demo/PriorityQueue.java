package com.example.demo;

/**
 * Created by think on 2018/5/29.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue(MaxHeap<E> maxHeap) {
        this.maxHeap = maxHeap;
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isREmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
