import java.util.Stack;

class MinStack {
    // Use the native Stack class instead of ArrayList
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        
        // If minstack is empty, current value is the minimum
        if (minstack.isEmpty()) {
            minstack.push(value);
        } else {
            // Compare current value with the top of minstack
            minstack.push(Math.min(minstack.peek(), value));
        }
    }
    
    public void pop() {
        // Native stack pop takes O(1) time
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */