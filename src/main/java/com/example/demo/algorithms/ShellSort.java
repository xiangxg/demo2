package com.example.demo.algorithms;

/**
 * Created by think on 2018/6/1.
 */
public class ShellSort {
    public static void sort(int [] arr){
        int n = arr.length;
        int h = 1;
        while(h < n/3) h = 3*h +1;
        while (h >=1){
            for (int i = h; i < n; i++) {
                int e = arr[i];
                int j = i;
                for (; j >= h && arr[j-h]>e ; j-=h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }
            h /=3;
        }

    }






    public static void sort(Comparable[] arr){

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {

            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        ShellSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();


    }
}
