package com.example.demo.algorithms;

/**
 * Created by think on 2018/5/31.
 */
public class BubbleSort {
    public static void sort(Comparable [] arr){
        for (int i = 0; i < arr.length; i++) {
            /*for (int j = 0 ; j < arr.length - i -1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0)
                    swap(arr,j,j+1);
            }*/
            int maxIndex = i;
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j].compareTo(arr[maxIndex]) > 0)
                    maxIndex = j;
            }
            arr[arr.length-i-1]=arr[maxIndex];
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        BubbleSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();


    }
}
