/** Brute Force 
Generates all permutations-
Time complexity: O(n!)
Space: O(n^2)
*/
public class Solution {
    boolean flag = false;
    
    public boolean checkInclusion(String s1, String s2) {
        permute(s1, s2, 0);
        return flag;
    }

    // Generate all permutations of a given string s1
    void permute(String s1, String s2, int l) { 
        if (l == s1.length()) { // length of permutation must match l1, since we are making the string from scratch
            if (s2.indexOf(s1) >= 0) // when length matches, we can also check for inclusion, why wait until all permutations are gen?
                flag = true;
        } 
        else {
            // Keep generating the permutations, from size l, we have to add (s1-l) more characters
            for (int i = l; i < s1.length(); i++) {
                s1 = swap(s1, l, i);
                permute(s1, s2, l + 1);
                s1 = swap(s1, l, i);
            }
        }
    }
    
    public String swap(String s, int i0, int i1) {
        if (i0 == i1)
            return s;
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }
    
    
}

/**
Sorting approach:
One string x is a permutation of other string y only if sorted(x)=sorted(y).
sort s1; sort all substrings of s2; compare all sorted s1 and sorted s2 substrings

Time complexity: O((L2-L1) * L1logL1) -> Time to sort String s1 = L1logL1
We iterate through a range, so (L2-L1)
*/

/**
Obsession for Hashmaps is real, leetcode is comparing two hashmaps as well
*/

/**
Sliding Window Approach is accepted, refer to below code only -
What we learnt so far -
We have to record frequency of every character, we can do it via hashmap or array
Comparing hashmap is possible but difficult, so we choose arrays

*/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        // 1. Recording in the array, frequency of characters
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];


        // TIME: O(L1)
        // s1 is the main length we need, so store only that many number of characters at a given time
        for (int i = 0; i < s1.length(); i++) { // s1 = adc ; s2 = dcda
        // It takes the characters from s1, but not necessary that it will update the first three indices only,
        // we can update any indices, so below, it is just updating the indices for first three characters of s1
            s1arr[s1.charAt(i) - 'a']++; // s1arr [1,0,1] <=> represents [a,b,c] <=> actual string is [a,c,d]
            s2arr[s2.charAt(i) - 'a']++; // s2arr [d,c,d]
        }

        // TIME: O(L2-L1)
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1arr, s2arr))
                return true;

            // s2 is the larger window we have to update
            // There is a freq update and freq decrease
            // Update freq for incoming character and decrement frequency for char we are removing
            // Where is the character we are adding? At index: s2.charAt(i + s1.length()) - 'a'
            // Where is the character we are removing: s2.charAt(i) - 'a'
            s2arr[s2.charAt(i + s1.length()) - 'a']++;
            s2arr[s2.charAt(i) - 'a']--;
        }

        // Time: O(26)
        // for the last permutation, we check again
        return matches(s1arr, s2arr);
    }
    
    public boolean matches(int[] s1arr, int[] s2arr) {
        for (int i = 0; i < 26; i++) { // comparing for all 26 characters
            if (s1arr[i] != s2arr[i])
                return false;
        }
        return true;
    }
}

/**
Visualisation of above sliding window approach:
s1 = "adc"
s2 = "dcda"
Index (Letter)	a	b	c	d	e	...	z
        s1arr	1	0	1	1	0	...	0
        s2arr	0	0	1	2	0	...	0

But we do not consider entire string length at once for s2, above array is what we would have for entire String
Right now, we just have a part of it, we could not even cover the entire array s1
Index (Letter)	a	b	c	
        s1arr	1	0	1	
        s2arr	0	0	1	

Time: O(L1) + O(26 * (L2-L1)) = O(L1 + 26. (L2 - L1)) = O(L1 + (L2 - L1)) = O(L2) AS L1 CANCEL EACH OTHER OUT
Space complexity: O(26+26)=O(1)
*/







/**
Didnt work, but we can still go through it once
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        StringBuilder window = new StringBuilder();
        Set<Character> hashSet1 = new HashSet<>();
        Set<Character> hashSet2 = new HashSet<>();
        for(Character ch: s1.toCharArray())
            hashSet1.add(ch);
        

        for(int i=0; i<s2.length(); i++){
            window = window.append(s2.charAt(i));     
            hashSet2.add(s2.charAt(i));
            if(i >= (k-1)){
                // we have reached a window size
                
                System.out.println("HS1: "+hashSet1);
                System.out.println("HS2: "+hashSet2);
                System.out.println(".........");
                
                if(hashSet1.equals(hashSet2))
                    return true;
                else{
                    hashSet2.remove(window.charAt(0));
                    window = new StringBuilder(window.substring(1));
                    
                }
                    
                    
            }
            
        }

        return false;
    }
}

// ab, ba <=> s2 = "eidbaooo"
// 1. generate all pemutations
// 2. Go over all of them and use contains(...)

/**
calculate the freq of all elements in s1, length of s1 = window size
set(a,b)

go over s2 and get a window of the same size
compare the elements every time

*/

