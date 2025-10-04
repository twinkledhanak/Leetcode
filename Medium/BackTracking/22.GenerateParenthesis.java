class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtracking(new StringBuilder(), 0, 0, answer, n);

        return answer;
    }


// Left count: no of left parenthesis ; Right count: no of right parenthesis - in the current string so far
// total length of string is 2n and if parenthesis are balanced, leftCount = n and rightCount = n
    private void backtracking(StringBuilder curString,int leftCount, int rightCount, List<String> answer, int n) {
        if (curString.length() == 2 * n) { // we start with "" and add/remove until length is 2n
            answer.add(curString.toString());
            return;
        }

        // instead of generating crap and checking if final string is valid, generate strings that are valid

        if (leftCount < n) { // we can still add ( as leftCount can be max n
            curString.append("("); // add
            backtracking(curString, leftCount + 1, rightCount, answer, n); // backtrack
            curString.deleteCharAt(curString.length() - 1); // remove
        }
        if (leftCount > rightCount) {
            curString.append(")"); // add
            backtracking(curString, leftCount, rightCount + 1, answer, n); // backtrack
            curString.deleteCharAt(curString.length() - 1); // remove
        }
    }
}

// Time: O(4^n/sqrt(n))
// Space: O(n),  so the space complexity would be the maximum depth of the recursion stack. At any given time, 
// the recursive function call stack would contain at most n function calls.


// WHat I TRIED AND WORKED
// Start with 3 of each type
// Keep a count at each state of how many are remaining
// Note how we are using a SB instead of storing everything in a path

class Solution {
     public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), result, n);
        return result;
    }

    private void backtrack(int leftRem, int rightRem, StringBuilder sb, List<String> result, int n) {
        // Base case: when no more parentheses left to add
        //if (leftRem == 0 && rightRem == 0) { // can only be 0 when string length is 6
        if (sb.length() == 2*n)   { // can use either condition they mean the same. Length 2n cannot be reached w/o using both
            result.add(sb.toString());
            return;
        }

        // Prune: invalid state if more '(' needed than ')' available
        if (leftRem > rightRem) 
            return;

        // Add '(' if any left
        if (leftRem > 0) {
            sb.append('(');
            backtrack(leftRem - 1, rightRem, sb, result, n);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // Add ')' if any left
        if (rightRem > 0) {
            sb.append(')');
            backtrack(leftRem, rightRem - 1, sb, result, n);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }

}
