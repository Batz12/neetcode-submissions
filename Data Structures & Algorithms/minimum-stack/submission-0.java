class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> prefixMinElementStack;

    public MinStack() {
        stack = new Stack<Integer>();
        prefixMinElementStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(prefixMinElementStack.isEmpty()) {
            prefixMinElementStack.push(val);
        } else {
            int minValue = Math.min(val, prefixMinElementStack.peek());
            prefixMinElementStack.push(minValue);
        }
    }
    
    public void pop() {
        stack.pop();
        prefixMinElementStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return prefixMinElementStack.peek();
    }
}
