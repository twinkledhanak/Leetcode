/** This implementation uses arrays, instead of maps */
/** m = length of keys */
class TrieNode {

    private final int R = 26; // Max no of children possible for a Trie - 26 alphabets
    private TrieNode[] children; // R children to node children

    public TrieNode() {
        children = new TrieNode[R]; // Everytime we initialse a trie, we initialise a root with 26 children
    }

    public boolean containsKey(char ch) { // If my trie has anything starting from ch=a or ch=b
        return children[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        children[ch -'a'] = node;
    }

    // We want to mark end of a word
    private boolean isEnd;
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) { // Eg. apple
        TrieNode node = root; // we start from the top always
        for (char currentChar: word.toCharArray()) { // a, p, p, l, e
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    /**
    Time Complexity: O(m), where m is the length of the key. Each operation involves examining or creating a node until the end of the key.
    Space Complexity: O(m). In the worst case, each newly inserted key might require adding m new nodes, resulting in O(m) space usage.
    */

    // search a prefix or whole key in trie and
    // returns the node where search ends
    // THE WORD STARTING WITH B WILL NOT BE PRESENT IN THE PATH OF WORDS WITH A
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char curLetter: word.toCharArray()) {
           if(!node.containsKey(curLetter))
                return null;
            else 
               node = node.get(curLetter);
           
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }

/*
    Time Complexity: O(m). We may have to go over one entire path of m characters, m is the length of the string in the trie
    Space Complexity: O(1).
*/

}