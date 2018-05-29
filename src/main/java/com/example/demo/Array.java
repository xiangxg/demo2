package com.example.demo;

/**
 * Created by think on 2018/5/2.
 */
public class Array<E> {
    private E [] data ;
    private int size;

    public Array(){
        this(10);
    }
    public Array(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException("Illegal capacity:　" + capacity);
        data = (E[])new Object[capacity];
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getCapacity(){
        return data.length;
    }

    public void add(E e){
       /* if (size == data.length)
            throw new IllegalArgumentException("Add fail : Array is full!");
        data[size++] = e;*/
       add(size,e);
    }

    public E getLast(){
        return data[size-1];
    }

    public void add(int index,E e){

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add fail : index is illegal ,index must between 0 and " + size);
        if (size == data.length)
            resize(data.length << 1);
        for (int i = size-1; i >= index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e){
        add(size,e);
    }

    public void  addFirst(E e){
        add(0,e);
    }

    private void resize(int capacity) {
        E [] dataNew = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            dataNew[i] = data[i];
        }
        data = dataNew;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add fail : index is illegal ,index must between 0 and " + size);

        E e = data [index];
        for (int i = index + 1; i < size ; i++) {
            data[i - 1] = data[i];
        }

        data[--size] = null;
        if (size < (data.length >> 2) && (data.length >> 1 != 0))
            resize (data.length >> 1);
        return  e;
    }

    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public boolean contains(E e){
        if(find(e) != -1)
            return  true;
        return  false;
    }

    public E  removeLast(){
        return remove(size - 1);
    }

    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add fail : index is illegal ,index must between 0 and " + size);
        return data[index];
    }

    public void set(int index , E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add fail : index is illegal ,index must between 0 and " + size);
        data[index] = e;
    }
    public E removeFirst(){
        return remove(0);
    }

    public int getSize(){
        return  size;
    }

    public void swap(int k, int j) {
        E temp = data[k];
        data[k] = data[j];
        data[j] = temp;
    }
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
    public static void main(String[] args){
        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }
        arr.removeFirst();
        System.out.println(arr);
    }


}
