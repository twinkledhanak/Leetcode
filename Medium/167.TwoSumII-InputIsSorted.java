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