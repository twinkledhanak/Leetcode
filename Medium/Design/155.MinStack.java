class MinStack {
    private Stack<int[]> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new int[]{val,val});
        else{
            // comapre with top
            min = Math.min(stack.peek()[1],val);
            stack.push(new int[]{val,min});
        }

    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /*

push() - at this time, maintain min?
pop() - same min is popped out, how to find next min? Keep track of min with all
top()
getMin()

Approach:
1. Stack() - O(1) ; except getMin()

// Time: O(1); Space: O(n)

 */