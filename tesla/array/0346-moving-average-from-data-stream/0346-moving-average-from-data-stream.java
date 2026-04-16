class MovingAverage {
    int sum;
    int count;
    int[] window;
    public MovingAverage(int size) {
        window = new int[size];
        count=0;
    }
    
    public double next(int val) {
        int index = count % window.length;  // wraps around ✅
        sum -= window[index];               // remove old value at this slot
        sum += val;                         // add new value
        window[index] = val;                // overwrite slot
        count++;

        return sum / (double) Math.min(count, window.length);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */