package sortingAlgorithm;

import java.util.Arrays;

public class QuickSort {
    /**
     * QuickSort O(n log(n) )
     * might lead to O(n2) if the number is in descending order.
     *
     * @param arr
     * @param low
     * @param high
     */

    public static void sort(int[] arr , int low , int high) {
        if(low < high) {
            int pivot = partition(arr , low , high);
            sort(arr , low , pivot-1);
            sort(arr, pivot+1 , high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low-1;
        int pivotElem = arr[high];
        for(int j= low; j<high ; j++) {
            if(arr[j] < pivotElem)  {
                i++;
                // swap it since it is less than pivot element.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap i+1 and high.
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,12,6,4,2,8,5};
        sort(arr,0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
