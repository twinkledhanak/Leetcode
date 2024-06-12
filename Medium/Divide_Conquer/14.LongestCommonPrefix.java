class Solution {

// Main caller 
public String longestCommonPrefix(String[] strs) {

    // basic conditions
    String result = "";
    if (strs == null || strs.length == 0) 
        return "";    
    
    // Main class
    result = longestCommonPrefix(strs, 0 , strs.length - 1); 
    return result;
}

// DIVIDE STEP
private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
        return strs[l];
    }
    else {
        int mid = (l + r)/2;
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        return commonPrefix(lcpLeft, lcpRight);
   }
}

// COMBINE STEP, called from DIVDE step
// Get the common the prefix from every side
String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());       
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
}

    
}
/*
[leetcode, leet, lee, le]

lhs: leetcode, leet       rhs: lee, le

combining using commonPrefix:
leet                        le

combining using commonPrefix:
le (FINAL OUTPUT)


Time complexity : O(S), where SSS is the number of all characters in the array, S=m⋅n
Time complexity is 2⋅T(n2)+O(m)2 \cdot T\left ( \frac{n}{2} \right ) + O(m)2⋅T( 
2
n
​
 )+O(m). Therefore time complexity is O(S).
In the best case this algorithm performs O(minLen⋅n) comparisons, where minLen is the shortest string of the array

Space complexity : O(m⋅log⁡n)

There is a memory overhead since we store recursive calls in the execution stack. There 
are log⁡n  recursive calls, each store need mmm space to store the result, so space complexity 
is O(m⋅log⁡n)
*/