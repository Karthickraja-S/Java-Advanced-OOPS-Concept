package sortingAlgorithm;

import java.util.Arrays;


public class SelectionSort {
    public static void sort(int[] arr) {
        // selection sort picks first element,
        // checks for is there any other min element after that, if so replace the curr with that
        // else just go for next number!
        for(int i=0;i<arr.length;i++) {
            int minNum = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] < arr[minNum]) {
                    minNum = j;
                }
            }
            if(i != minNum) {
                int temp = arr[i];
                arr[i] = arr[minNum];
                arr[minNum] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,12,6,4,2,8,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
