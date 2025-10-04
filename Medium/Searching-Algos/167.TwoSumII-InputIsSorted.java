class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int a=0, b=n-1;
        int res[] = new int[]{0,0};

        while(a<b){
           // System.out.println("numbers[a]: "+numbers[a]+" ,numbers[b]: "+numbers[b]);
            if((numbers[a]+numbers[b] == target) ){
                if (a!=b)
                    res = new int[]{a+1,b+1};
            }
                 

            if(numbers[a]+numbers[b] > target)
                b--; // Manipulating the largest
            else
                a++;        
        }
        
        return res;

    }
}

// Time: O(n) ; Space: O(1)

// Even better solution is to use Binary Search.
// Time: O(logN) ; Space: O(1)

// idea is to search for complement using binary search
// Higher level snippet
/*
  int low=0, high=numbers.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int complement = target-numbers[mid];
            
            if(complement < numbers[mid])
                high = mid-1;
            else
                low = mid+1;    
        }
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            int complement = target - numbers[i];

            // Perform binary search for the complement
            while (low <= high) {
                int mid = low + (high - low) / 2;
                
                if (numbers[mid] == complement) {
                    return new int[]{i + 1, mid + 1}; // Found the pair
                } else if (numbers[mid] < complement) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        // In case there is no solution, though the problem guarantees one.
        return new int[]{-1, -1};
    }
}
