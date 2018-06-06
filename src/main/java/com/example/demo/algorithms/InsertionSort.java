package com.example.demo.algorithms;

/**
 * Created by xiangxuegui on 2018/5/31.
 */
public class InsertionSort {
    public static void sort(Comparable [] arr){
        for (int i = 1; i < arr.length; i++) {
            //方法一
            /*for (int j = i; j >0 ; j--) {
                if (arr[j].compareTo(arr[j-1]) <0)
                    swap(arr,j,j-1);
            }*/
            //方法二
            /*for (int j = i; j >0 && arr[j].compareTo(arr[j-1]) <0; j--) {
                swap(arr,j,j-1);
            }*/
            //方法三
            Comparable e = arr[i];
            int j = i;
            for (; j >0 && arr[j-1].compareTo(e) > 0 ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        InsertionSort.sort(arr);
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
