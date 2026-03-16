
// we can write everything using for or while; only structure is different
// We still have to take care for initialization, validitiy & increment/decrement

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            // Another check for i<j to prevent out of bounds
            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;

            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))    
                j--;

            // Check how we are comparing characters
            if(Character.toLowerCase(s.charAt(i)) !=
                Character.toLowerCase(s.charAt(j)))    
                return false;

            i++;
            j--;    
        }


        return true;
        
    }
}

Time: O(n)
Space: O(1) since only pointers are used

Another variant of this solution:

class Solution {
    public boolean isPalindrome(String s) {
        String regex= "[^a-zA-Z0-9]+";
        s = s.replaceAll(regex,"").toLowerCase();

        if(s.isEmpty())
            return true;

        int a=0, b = s.length()-1;
        while(a<b){
            if(s.charAt(a) != (s.charAt(b)))
                return false;
            a +=1;
            b -=1;    
        }   
        return true;
    }
}

Time: O(n)
Space: O(1) but if we consider the regex part and replaeAll() then it is O(n)

Critical difference between both solutions:

1. My solution:
Pre-processing the string
Working with cleaner data (which is a simplied problem)
But, it does replaceAll() which means internally it creates a new copy of the string, space: O(n)


2. Editorial solution:
Does not pre-process the string 
Processes it ON THE FLY during traversal
Think about situations like streaming data - where we cant apply a given transformation over entire dataset
Since we have a constant moving stream of data 