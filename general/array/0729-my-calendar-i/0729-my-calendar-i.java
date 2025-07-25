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
    TreeMap<Integer, Integer> calcy;
    public MyCalendar() {
    calcy = new TreeMap();

    }
    
    public boolean book(int start, int end) {
    Integer prevBook = calcy.floorKey(start);
    Integer nextBook = calcy.ceilingKey(start);
    if((prevBook==null || calcy.get(prevBook)<=start) && (nextBook==null || end<=nextBook)) 
    { 
    calcy.put(start, end);
    return true;
    }
    return false;
    }
}
 */
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */