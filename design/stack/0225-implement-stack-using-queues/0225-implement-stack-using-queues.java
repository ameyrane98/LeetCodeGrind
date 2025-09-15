class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;
    public MyStack() {
        que1= new LinkedList<>();
        que2= new LinkedList<>();
    }
    
    public void push(int x) {
       while(!que1.isEmpty()){
            que2.add(que1.remove());
       }
        que1.add(x);
        while(!que2.isEmpty()){
            que1.add(que2.remove());
       }
    }
    
    public int pop() {
        return que1.poll();
    }
    
    public int top() {
        return que1.peek();
    }
    
    public boolean empty() {
       if(!que1.isEmpty()){
            return false;
       }
       return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */