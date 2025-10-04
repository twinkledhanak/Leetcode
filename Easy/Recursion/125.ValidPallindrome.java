class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        return helper(s, 0, str.length() - 1);
    }

    private boolean helper(String s, int i, int j) {
        // Base case: If pointers have crossed, the string is a palindrome
        if (i >= j) {
            return true;
        }

        // Move the left pointer if the current character is not alphanumeric
        if (!Character.isLetterOrDigit(s.charAt(i))) {
            return helper(s, i + 1, j);
        }

        // Move the right pointer if the current character is not alphanumeric
        if (!Character.isLetterOrDigit(s.charAt(j))) {
            return helper(s, i, j - 1);
        }

        // Check if the characters are equal (case-insensitive)
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
            return false;
        }

        // Move both pointers inward and continue the check
        return helper(s, i + 1, j - 1);
    }
}

// Time: O(n)
// Space: O(n)


// ALTERNATE SOLUTION::

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]+","");
        str = str.replaceAll("\\s+","");
        if(str == "")
            return true;
            
        return helper(0,str.length()-1,str);
    }

    public boolean helper(int start, int end, String str){
        if(start>=end) // When left and right pointers cross each other, we have Pallindrome
            return true;

        if(str.length() == 1) // Imp condition!!!
            return true;

        return (str.charAt(start) == str.charAt(end)) & helper(start+1,end-1,str);        
    }
    
}