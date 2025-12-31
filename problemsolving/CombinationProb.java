import java.util.ArrayList;
import java.util.List;

public class CombinationProb {
    /**
     * Print all possible numbers( Without duplicates ) in an array that add upto given number. Example:
     * Input: arr- 1,2,3,4,5,6, target=12
     * Output:
     * 1 2 3 6
     * 1 2 4 5
     * 1 5 6
     * 2 4 6
     * 3 4 5
     */
    public static void populateUniqueCombinations(int[] arr , int target , List<List<Integer>> ans) {
        int n = arr.length;

        for(int i=1;i< (1<<n);i++) {
            // if arr.len = 3, then possible combination will be 7
            StringBuilder binaryStr = new StringBuilder(Integer.toBinaryString(i));
            // append zeros before the binaryStr such that it equals to arr.len
            // Instead of
            while (binaryStr.length() < n) {
                binaryStr.insert(0, '0');
            }
            // System.out.println(binaryStr);
            // loop binaryStr and check for '1' exists. If so pick that index
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for(int idx = 0;idx < binaryStr.length(); idx++) {
                if(binaryStr.charAt(idx) == '1') {
                    temp.add(arr[idx]);
                    sum += arr[idx];
                }
            }
            if(sum == target) {
                ans.add(temp);
            }
        }
    }

    public static void populateUniqueCombinationsII(int[] arr , int target , List<List<Integer>> ans) {
        int n = arr.length;

        for(int i=1;i< (1<<n);i++) {
            // instead of converting to binaryStr and appending zeros in start we can do with the & condition
            List<Integer> temp = new ArrayList<>();
            int sum=0;
            for (int shift = 0; shift < n; shift++) {
                if( (i & (1<<shift)) != 0) {
                    sum += arr[shift];
                    temp.add(arr[shift]);
                }
            }
            if(sum == target) {
                ans.add(temp);
            }
        }
    }
    // Recursive approach
    public static void populateUniqueCombinationsIII(int[] arr ,
                                                     int curridx ,
                                                     int currSum ,
                                                     int target ,
                                                     List<Integer> temp, List<List<Integer>> ans) {
        if(currSum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(currSum > target) {
            return;
        }
        for(int idx = curridx;idx<arr.length;idx++) {
            temp.add(arr[idx]);
            populateUniqueCombinationsIII(arr,curridx+=1,currSum+arr[idx],target,temp,ans);
            // the below method will generate all the combinations with duplicate
           //  populateUniqueCombinationsIII(arr,curridx,currSum+arr[idx],target,temp,ans);
            temp.remove((Integer) arr[idx]);
        }
    }

    static void main() {
        int arr[] = {1,2,3,4,5,6};
        int target = 12;
        List<List<Integer>> ans = new ArrayList<>();
        populateUniqueCombinations(arr,target,ans);
        System.out.println(ans);
        ans.clear();

        populateUniqueCombinationsII(arr,target,ans);
        System.out.println(ans);
        ans.clear();

        populateUniqueCombinationsIII(arr,0,0,target,new ArrayList<>(),ans);
        System.out.println(ans);
        ans.clear();
    }
}
