package sortingAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,12,6,4,2,8,5};
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for(int j=0;j< arr.length;j++){
                if(arr[i] < arr[j]) {
                    swap = true;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            if(!swap){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
