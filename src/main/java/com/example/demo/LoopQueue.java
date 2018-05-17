package com.example.demo;

/**
 * Created by think on 2018/5/7.
 */
public class LoopQueue<E> implements Queue<E> {

    private E [] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity +1];
    }
    public LoopQueue(){
        this(10);
    }
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)//队列已满
            resize((getCapacity() << 1 ) + 1 );
        data[tail] = e;
        tail = (tail + 1)%data.length;
        size++;

    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("queue is empty");
        E e = data[front];
        data[front] = null;
        front = (front+1)%data.length;

        if (size == getCapacity()/4 && getCapacity()/2 != 0)
            resize(getCapacity()/2);
        return e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = front ; i != tail ; i = (i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public E getFront() {
        return null;
    }

    public int getCapacity(){
        return data.length - 1;
    }
}
