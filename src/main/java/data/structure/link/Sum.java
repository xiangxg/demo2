package data.structure.link;

/**
 * Created by think on 2019/10/23.
 */
public class Sum {
    public static void sum(int arr[]){
        int sum = sum(arr,0);
        System.out.println(sum);
    }

    private static int sum(int[] arr, int i) {
        if (i == arr.length)
            return 0;
        return arr[i] + sum(arr,i+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        sum(arr);
    }
}
