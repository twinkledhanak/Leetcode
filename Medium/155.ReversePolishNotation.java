class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (i=0; i<n; i++){
            if (tokens[i].equals("+") | tokens[i].equals("-") | tokens[i].equals("*") |
            tokens[i].equals("/")){
                if (!stack.isEmpty()){
                    int elem1 = stack.pop();
                    int elem2 = stack.pop();
                    switch(tokens[i]){
                        case "+": stack.push(elem2+elem1); break;
                        case "-": stack.push(elem2-elem1); break;
                        case "*": stack.push(elem2*elem1); break;
                        case "/": stack.push(elem2/elem1); break;
                    }
                    
                }
            }
            else{
                //System.out.println("Pushed to stack: "+tokens[i]);
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        if(!stack.isEmpty()){
            return stack.peek();
        }
        else
            return -1;


    }
}