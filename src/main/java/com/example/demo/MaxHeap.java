package com.example.demo;

import java.util.Random;

/**
 * Created by think on 2018/5/28.
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }
    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(E [] arr) {
        data = new Array<E>(arr);
        for (int i = parent(data.getSize() -1); i >=0 ; i--) {
            siftDown(i);
        }
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
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
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

    public E replace(E e){
        E max = findMax();
        data.set(0,e);
        siftDown(0);
        return max;
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
