class MyCircularQueue {
        int Rear;
        int Front;
        int size;
        int[] arr;
        int count;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Front=0;
        Rear=0;
        size=k;
        count=0;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            arr[Rear]=value;
            Rear=(Rear+1)%size;
            count++;
            return true;
        }

        return false;
       
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            arr[Front]= -1;
            Front = (Front + 1) % size; 
            count--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[Front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(Rear - 1 + size) % size];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count== size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */