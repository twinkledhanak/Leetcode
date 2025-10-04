class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int lastDigit = x % 10; // extra last digit
            x = x / 10;

            // rev = rev * 10 + lastDigit; -> Checking overflow for all components
            // we have 2 conds, > or == ; < or ==;
            // Checking for Max overflow , Integer.MAX_VALUE;  2147483647, rev is > 214748364 or rev is 2147483649 (lastDigit > 7)
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && lastDigit > 7)) 
                return 0;

            // Checking for Min overflow , Integer.MIN_VALUE;  -2147483648
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && lastDigit < -8))
                return 0;

            rev = rev * 10 + lastDigit;
        }
        return rev;
    }
}

/*
Time: O(logX , since loop variable is decreasing in multiples
Space: O(1), only variables
*/