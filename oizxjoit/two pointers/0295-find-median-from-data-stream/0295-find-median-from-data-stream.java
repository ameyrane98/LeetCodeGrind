class MedianFinder {
    ArrayList<Integer> arr ;
    public MedianFinder() {
        arr = new ArrayList<>();
    }   
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        arr.sort((a,b)->b-a);
        int len = arr.size();

        if(len==1){
            return arr.get(0);
        }

        if(len==2){
            return (double) (arr.get(0)+arr.get(1)) / len;
        }

        int fast = 2;
        int slow = 0;

        while(fast<len){
            slow++;
            fast+=2;
        }

        if(len % 2 != 0 ){
            return arr.get(slow);
        }else{
            
            return (double) (arr.get(slow)+arr.get(slow+1)) / 2;
        }

       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */