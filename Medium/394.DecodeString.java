class Solution {
    public String decodeString(String s) {
        int n = s.length();
        String temp = "";
        Stack<String> stack = new Stack<>();
        String retString = "";

        char[] ch = s.toCharArray();
        for(int i=0; i<n; i++){
            if(ch[i] != ']'){
                stack.push(ch[i]+""); // Anything except ], push onto the stack
                //System.out.println("Pushed: "+ch[i]);
            }
            else{
                // We encountered ], so now start popping until [
                temp = "";    
                while(!stack.peek().equals("[")){
                    //System.out.println("peek inside: "+stack.peek()); 
                    temp = stack.peek() + temp;
                    stack.pop();
                }
                stack.pop(); // To remove [
                //System.out.println("peek: "+stack.peek()); 


                // WE CAN HAVE NUMBERS IN STACK, 1,0,0 -> WE ARE MAKING A NUMBER OUT OF THE DIGITS
                // CONVERTING 1,0,0 FROM STACK TO 100 
                String num = ""; 
                while(!stack.isEmpty() && stack.peek().matches("\\d+")){
                     num = stack.pop() + num;
                }
                int k = Integer.parseInt(num);

                stack.push(generateString(temp,k));
            } 

        }

        // STRINGS CAN BE STORED IN STACK AS : AAA;BC (top) , WE NEED TO COMBINE THEM AS AAABC
        while(!stack.isEmpty()){
            retString = stack.pop() + retString;
        }

        return retString;
    }


    public String generateString(String s, int k){
        String result = "";
        while(k>0){
            result += s;
            k--;
        }
        //System.out.println("Result: "+result);
        return result;
    }
}
