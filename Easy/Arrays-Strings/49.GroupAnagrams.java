class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) { // [eat, tea, cat]
            char[] ca = s.toCharArray(); // e,a,t
            Arrays.sort(ca); // a,e,t
            String key = String.valueOf(ca); // aet
            if (!ans.containsKey(key)) 
                ans.put(key, new ArrayList()); // aet -> {}
            ans.get(key).add(s); // aet -> {eat}
        }
        return new ArrayList(ans.values());
    }
}

/*
Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.

Space Complexity: O(NK), the total information content stored in ans.

*/