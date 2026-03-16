class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')'); map.put('[',']'); map.put('{','}'); // Order is imp
        
        for(Character ch: s.toCharArray()){
            // Every open character, push in stack
            if(ch=='[' || ch=='(' || ch=='{')
                stack.push(ch);

            else{ // it is closing character
                if(stack.isEmpty()) // Eg. s = "]"
                    return false; // do not consider anything, just terminate
                else{
                    Character stPop = stack.peek();
                    if(ch == map.get(stPop))// stack top is matching with current char
                        stack.pop();
                    else
                        return false;    
                }
            }


        }
        
        return stack.isEmpty();
    }
}
// Consider edge cases ] and (])

// Feb 2026 solution

class Solution {
    // Note how static variable is defined
    // and initialized
    static Map<Character,Character> map = new HashMap<>();
    static {
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        

        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            else{
                //Now we have closing bracket, but nothing in stack
                // WHich means, ip string could be "]"
                // which is invalid
                if(stack.isEmpty() || stack.peek() != map.get(ch))    
                    return false;
                stack.pop();  
            }  
        }

        return stack.isEmpty();
    }
}

Time: O(n)
Space: O(n)