class MovingAverage {
    Queue<Double> que;
    int windowSize;
    double sum=0;
    public MovingAverage(int size) {
        que=new LinkedList<>();
        windowSize=size;
    }
    
    public double next(int val) {
        if(que.size()==windowSize){
            sum-=que.poll();
        }

        que.add((double) val);
        sum+=val;
        double avg = sum/ (double) que.size();
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */