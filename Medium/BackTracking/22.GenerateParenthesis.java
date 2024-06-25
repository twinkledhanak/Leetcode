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