class MinStack {
    Stack<Integer> stck;
    Stack<Integer> minStck;

    public MinStack() {
        stck= new Stack();
        minStck= new Stack();
    }
    
    public void push(int val) {
        stck.push(val);

        if(minStck.isEmpty() || val<= minStck.peek()){
            minStck.push(val);
        }
    }
    
    public void pop() {
       
        if(stck.peek().equals(minStck.peek())){
            minStck.pop();
        }
        stck.pop();
    }
    
    public int top() {
        return stck.peek();
    }
    
    public int getMin() {
        return minStck.peek();
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