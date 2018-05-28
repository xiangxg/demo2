package com.example.demo;

/**
 * Created by think on 2018/5/28.
 */
public class MapHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MapHeap(int capacity) {
        this.data = new Array<>(capacity);
    }
    public MapHeap() {
        this.data = new Array<>();
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isREmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("parent is not exist!");
        return (index -1)/2;
    }

    private int leftChild(int index){
        return index*2+1;
    }
    private int rightChild(int index){
        return index*2+2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() -1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k))>0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    public E findMax(){
        return data.get(0);
    }

    public E extractMax(){
        E max = findMax();
        //交换根元素和最后一个元素
        data.swap(0,data.getSize() - 1);
        //删除原根元素，亦交换后的最后元素
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if ((j+1)<data.getSize() && data.get(j).compareTo(data.get(j + 1))<0)
                j++;
            //data[j]是左右子树中最大的元素
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k,j);
            k = j;
        }
    }
}
