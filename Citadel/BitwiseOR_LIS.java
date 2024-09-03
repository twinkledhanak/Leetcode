/*
Return an array of all distinct bitwise-or of all increasing subsequences of an array in sorted order.
eq: array: [3, 1, 2, 4]
increasing subsequences: (3), (1), (2), (4), (3,4), (1,2), (1,4) (2,4), (1,2,4).
For each subsequence above find all distinct bitwise-or and return that list in sorted order. -> do this in java

Tried to visualize this solution in tree format and wanted to use backtracking. But it has very high complexity.
{},{3},{2},{1},{4}; {3,1} X  {3,2} X  {3,4} Yes
We can include all elements from i+1 until n for a given element, not consider previous
We can make a tree, considering all choices
But, we use DP as we want to reduce the complexity
We can use recursion+memo here, but sometimes Tabulation is much better approach and easier with better Time Complexity
*/

/**
Starting on same lines as LIS, in LIS - we just get the length of LIS. In dp[], we keep track of all lengths of LIS
dp[i] = val; It means that, until index i of both main array and dp, we will store length of all LIS until i. max len LIS has value
'val'.
I wanted to modify that solution and use two loops as:
for(i from 1 to dp.length)
    for(j=0; j<i; j++)
        // eg. [10,22,9,33] -> When i=1, consider element until 22. dp[i] will have some LIS val for all elements until 22
        // j will always start from 0, until i -> so, j=> 10,22 ; then j=>10,22,9; then j=>10,22,9,33 and so on
        if(arr[j] < arr[i]){
            // condition to perform something valid for increasing subseq;
            // Put in heap
        }
        //*****
        // The problem here is that, j=> 10,22 ; then j=>10,22,9; then j=>10,22,9,33 and so on.
        // 10,22 => will be considered again and again. So, if we put in Heap, it will be duplicated.
        // Hence, we do not use Heap here
        // ALWAYS DRY RUN THE CODE BEFORE FINALIZING IT
        // We could've used HashSet directly. But we are using TreeSet here.
https://leetcode.com/discuss/interview-question/5472861/Citadel-Hackerrank-OA
*/

import java.util.*;

public class DPSolution {

    public static List<Integer> findAllDistinctBitwiseOrs(int[] array) {
        Set<Integer>[] dp = new HashSet[array.length]; // array of sets
        Set<Integer> resultSet = new TreeSet<>();
        resultSet.add(0);

        for (int i = 0; i < array.length; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(array[i]);

            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    for (int orResult : dp[j]) {
                        dp[i].add(orResult | array[i]);
                    }
                }
            }

            resultSet.addAll(dp[i]); // in LIS, we do - dp[i] = max + 1;
        }

        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] array = {4,2,4,1};
        List<Integer> result = findAllDistinctBitwiseOrs(array);
        System.out.println(result);
    }
}

import java.util.*;

public class GoodnessValues {
    
    public static int[] getDistinctGoodnessValues(int[] arr) {
        Set<Integer> goodnessSet = new TreeSet<>();
        
        // Start with an empty subsequence, which has a goodness of 0
        goodnessSet.add(0);
        
        // Process each element in the array
        for (int i = 0; i < arr.length; i++) {
            List<Integer> currentGoodnessList = new ArrayList<>(goodnessSet);
            
            for (int goodness : currentGoodnessList) {
                int newGoodness = goodness | arr[i];
                goodnessSet.add(newGoodness);
            }
        }
        
        // Convert the set to an array and return it
        int[] result = new int[goodnessSet.size()];
        int index = 0;
        for (int val : goodnessSet) {
            result[index++] = val;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 1};
        int[] result = getDistinctGoodnessValues(arr);
        System.out.println(Arrays.toString(result));  // Output: [0, 1, 2, 4, 6]
    }
}
