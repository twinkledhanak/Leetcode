class MinStack {

    Stack<Integer> stack;
    int minVal = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minVal > val)
        minVal = val;
    }
    
    public void pop() {
        if(!stack.isEmpty())
        stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty())
        return stack.peek();
        else
        return -1;
    }
    
    public int getMin() {
        return minVal;
        // @TODO - If the minValue element was popped, this method will return a stale value
        // Change it to store min element with every stack entry
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