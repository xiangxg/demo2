package com.example.demo;

/**
 * Created by think on 2018/5/11.
 */
public class Sum {

    public static void main(String[] args){
        int [] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(sum(arr,0));
    }

    private static int sum(int[] arr, int l) {
        if (arr.length == l)
            return 0;
        return arr[l]+sum(arr,l+1);
    }

}
