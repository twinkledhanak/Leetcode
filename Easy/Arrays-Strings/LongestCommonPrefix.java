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

// If we are using Tries

Once all words are inserted, the longest common prefix is simply:
the longest path starting from the root where every node has exactly one child and isEndOfWord is false.
Because:

If a node has more than one child, that’s where strings diverge.
If a node is the end of a word, that’s where one string ends before others continue.

// If we are using vertical scanning,
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (
                    i == strs[j].length() || strs[j].charAt(i) != c
                ) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}

array = [flower,flow,flight]
//we take the first string and calculate its length -> we only check for all chars in first string. If we found a mismatch at any one
//point, we can skip all other comparisons

That is what above code is doing,
for all indices from 0 to len(flower):
    take f from first string at index i 

    for all j,
    compare first char of each string with i


Time complexity : O(S) , where S is the sum of all characters in all strings.
In the worst case there will be n equal strings with length m and the algorithm performs S=m⋅n character comparisons.
Even though the worst case is still the same as Approach 1, in the best case there are at most n⋅minLen comparisons where minLen is the length of the shortest string in the array.
Space complexity : O(1). We only used constant extra space.

//Refer to S explanation in file 208.ImplementTrie.java

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

public class Solution {
    TrieNode root = new TrieNode();

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // 1️⃣ Build the Trie
        for (String word : strs) 
            insert(word);

        // 2️⃣ Find the prefix by traversing only-child path
        return getPrefix(strs[0]);
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c); // learn how to go to next node
        }
        node.isEnd = true;
    }

    // Typical insert function for comparison
    /**
    // Insert a word
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode()); // more compact
        }
        node.isEndOfWord = true;
    }    
    */

    private String getPrefix(String firstWord) {
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;

        for (char c : firstWord.toCharArray()) {
            // stop if more than 1 child or reached end of a word
            if (node.children.size() != 1 || node.isEnd)
                break;
            sb.append(c);
            node = node.children.get(c);
        }
        return sb.toString();
    }
}
