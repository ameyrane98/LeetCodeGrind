class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] startTimes= new int[intervals.length];
        int[] endTimes= new int[intervals.length];
        int idx=0;
        int roomCounter=0;
        int maxRooms=Integer.MIN_VALUE;
        for(int[] interval : intervals){
            startTimes[idx]=interval[0];
            endTimes[idx]=interval[1];
            idx++;
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        //**Heap approach */
        // PriorityQueue<Integer> min_Heap= new PriorityQueue<>();

        // for(int[] interval : intervals){
        //    if(!min_Heap.isEmpty() && interval[0]>=min_Heap.peek()){
        //         min_Heap.remove();
               
        //    }
        //     min_Heap.add(interval[1]);
        // }

        // return min_heap.size;

       int strPtr=0;
       int endPtr=0;

       while(strPtr<startTimes.length){
            if(startTimes[strPtr]<endTimes[endPtr]){
                // means a meeting stared bwrofe one meetirng ended
                roomCounter+=1;
                strPtr++;
            }else{
                roomCounter-=1;
                endPtr++;
            }
            maxRooms=Math.max(roomCounter,maxRooms);
       }

       return maxRooms;
    }
}