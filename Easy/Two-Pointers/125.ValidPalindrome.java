
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