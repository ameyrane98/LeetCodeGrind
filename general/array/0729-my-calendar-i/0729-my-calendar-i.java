class MyCalendar {
    ArrayList<int[]> arr;
    public MyCalendar() {
        arr= new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {   
        for(int[] event : arr){
            int currStart= event[0];
            int currEnd= event[1];

            if(startTime< currEnd && endTime>currStart){
                return false;
            }
        }
        
        arr.add(new int[]{startTime,endTime});
        return true;
    }
}


/**
O(log n)
class MyCalendar {
    TreeMap<Integer,Integer> calendar = new TreeMap<>();
    public MyCalendar() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }
}
 */
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */