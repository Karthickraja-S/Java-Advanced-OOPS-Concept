package sortingAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void mergesort(int[] arr , int left , int right) {
        if(left < right) {
            int mid = (left+right)/2;
            mergesort(arr , left , mid);
            mergesort(arr , mid+1  ,right);

            merge(arr,left , mid , right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;

        int leftArr[] = new int[leftArrSize];
        int rightArr[] = new int[rightArrSize];

        for(int i=0;i<leftArrSize;i++) {
            leftArr[i] = arr[left+i];
        }

        for(int i=0;i<rightArrSize;i++) {
            rightArr[i] = arr[mid+i+1];
        }
        // now merge those leftArr & rightArr to the arr array!
        int i=0,j=0,k=left;
        while(i<leftArrSize && j<rightArrSize) {
            if(leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // fill balance numbers
        while(i < leftArrSize) {
            arr[k++] = leftArr[i];
            i++;
        }
        while(j < rightArrSize) {
            arr[k++] = rightArr[j];
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,12,6,4,2,8,5};
        mergesort(arr,0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
