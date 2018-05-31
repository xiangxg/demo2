package com.example.demo.algorithms;

/**
 * Created by xiangxuegui on 2018/5/31.
 */
public class InsertionSort {
    public static void sort(Comparable [] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (arr[j].compareTo(arr[j-1]) <0)
                    swap(arr,j,j-1);
            }
        }
    }
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

      /*  int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.example.demo.algorithms.InsertionSort", arr);

        return;*/
    }

}
