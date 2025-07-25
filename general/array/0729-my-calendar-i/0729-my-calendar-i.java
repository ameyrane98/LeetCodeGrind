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
Approach:

TreeMap is used because it sorts its keys in natural order (in Integer that order would be ascending)
TreeMap is also used because of the higherEntry method. HigherEntry returns the next bigger key (compared to the value given, in this case, "start") from the map.
HigherEntry() example: TreeMap: {1=One, 2=Two, 3=Three, 4=Four, 5=Five} --> The higherEntry value for 3 is 4=Four
Important note, the map key is the end time and the value is the start time.

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