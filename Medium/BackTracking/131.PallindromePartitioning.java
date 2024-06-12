class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) 
            result.add(new ArrayList<String>(currentList));

        for (int end = start; end < s.length(); end++) {
            // ******************************************************
            // whenever any condition for subsets, put them first
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));

                dfs(end + 1, result, currentList, s);

                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}

// Time: In general a string of length N will have O(2^N) partitions
// for each partition, we check if they are pallindrome, so O(n) , where n - length of string
// Combining both, we get, O(n * 2^n)