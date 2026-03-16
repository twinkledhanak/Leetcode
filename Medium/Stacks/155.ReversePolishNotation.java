class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (i=0; i<n; i++){
            // This line can be simplied sooo much, refer sol below
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

// Feb 2026 solution

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s: tokens){
            if(!stack.isEmpty() && "+-*/".contains(s)){
                int b = stack.pop();
                int a = stack.pop();
                switch(s){
                    case "+": stack.push(a+b); break;
                    case "-": stack.push(a-b); break;
                    case "*": stack.push(a*b); break;
                    case "/": stack.push(a/b); break;
                }
            }
            else
            stack.push(Integer.parseInt(s));
        }

        return stack.peek();
    }
}