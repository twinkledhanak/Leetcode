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