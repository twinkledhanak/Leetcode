class Solution {
    public boolean isValid(String s) {
        HashMap <Character,Character> hmap = new HashMap<Character,Character>();
        hmap.put(')','(');
        hmap.put('}','{');
        hmap.put(']','[');

        Stack<Character> stck = new Stack<>();
        for (char ch : s.toCharArray()){
            if (hmap.containsKey(ch)){
                if(stck.empty())return false;
                char topE = stck.pop();
                if (topE != hmap.get(ch)){
                    return false;
                }
            }
            else{
                stck.push(ch);
            }

        }
        return stck.empty();
        
    }
}