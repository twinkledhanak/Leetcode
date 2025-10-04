class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];

        // Building the last index array (we can build a hashlastDigitMap too)
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < S.length(); ++i) {

            j = Math.max(j, last[S.charAt(i) - 'a']);

            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}

// Refer to Neetcode for video solution
// last range of a character is what we're looking for


// Solution from Neetcode:
class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> lastDigitMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            lastDigitMap.put(s.charAt(i), i); // set the last position for every character
        }


        int end = 0;
        int i = 0;

        while (i < s.length()) {
            // Now we calculate size of every partition
            int count = 0;

            // Initial partition size = last index of first character
            end = Math.max(end, lastDigitMap.get(s.charAt(i))); // abcdade => first part has to end at index: 4, then this will change
            // we check for all characters from start until this partition index, that their ranges are met
            while (i <= end) {
                end = Math.max(end, lastDigitMap.get(s.charAt(i)));
                i++;
                count++;
            }


            list.add(count); // we got the partition size
        }
        return list;
    }
}

// Time: O(n), Space: O(n)