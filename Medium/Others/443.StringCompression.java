/**
Higher level intuition:
We do not really remove element from array
We just override the array values
We keep a separate variable to return modified array's length
It is very similar to pulling forward the elements and overriding values

[a,a,b,b] -> [a,2,b,2]
[a,b,b,b] -> [a,b,3] => Single character -> no compression

Time: O(n); Space: O(1)

*/

class Solution {
    public int compress(char[] arr) {
        int i = 0, compressedLength = 0;//O/P
        // compressedLength is the index where we override the value in original array
        // it is also the length we return
        // See the duality of variables :P

        while (i < arr.length) {
            // ctr is to keep track of character frequency
            // If we keep ctr as 0, then it will cause problem for single character, so ctr=1
            int ctr = 1; 
            
            // Technique of comparing all group together
            // What I had -> two pointers and comparing i & i+1 everytime
            // Instead do this:
            while (i + ctr < arr.length && arr[i + ctr] == arr[i]) { // (i+ctr)<n && every elem in group is equal to first char
                ctr++; // [b,b,b...] compare all indexes from 2 to n , make sure they are b
            }
            
            // now we have counted all b's in our current group
            arr[compressedLength++] = arr[i];// in a[0] put b, to get [b,...] instead of [b,b,b] 



            if (ctr > 1) { // suppose char is single digit (Eg. 3) or multiple digits (Eg. 12)
                for (char c : Integer.toString(ctr).toCharArray()) { // For every individal char in 12, 1, then 2 
                    arr[compressedLength++] = c;
                }
            }

            // restart from next group, we move our pointer directly to start of next group
            // instead of incrementing it one by one
            i += ctr;
        }
        return compressedLength;
    }
}