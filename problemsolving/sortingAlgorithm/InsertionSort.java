package sortingAlgorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;
            // pick the element, check its previous array. and swap if it is greater than the picked
            // element.
            while(j>=0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,12,6,4,2,8,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
