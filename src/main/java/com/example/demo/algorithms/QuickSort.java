package com.example.demo.algorithms;

/**
 * Created by xiangxuegui on 2018/6/4.
 */
public class QuickSort {
    public static void sort(Comparable [] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0){
                j++;
                swap(arr,j,i);
            }
        }
        swap(arr,j,l);
        return j;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        QuickSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
