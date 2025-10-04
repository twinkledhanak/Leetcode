class Solution {
    public String longestCommonPrefix(String[] dataset) { // [flower,flow,flight]
        if (dataset.length == 0) 
            return "";
        String prefix = dataset[0]; // prefix: flower

        // Take a reference of one string and manipulate it using others

        for (int i = 1; i < dataset.length; i++) // 
            while (dataset[i].indexOf(prefix) != 0) { // flow.indexOf(flower) != 0
            prefix = prefix.substring(0, prefix.length() - 1); // keep reducing the length of prefix: flower until it matches flow
            if (prefix.isEmpty()) 
                return "";
        }
        return prefix;
    }
}

// Time: O(s) => s = sum of all characters in all strings
// Space: O(1) => constant