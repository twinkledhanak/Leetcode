class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<int[]> stack = new Stack<>(); // {element, minimum until given element}

    public void push(int x) {
        if(!stack.isEmpty())
            stack.push(new int[]{x,Math.min(x, stack.peek()[1])});
        else
            stack.push(new int[]{x,x});
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