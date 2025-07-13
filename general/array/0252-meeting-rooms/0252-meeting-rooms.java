class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int prev_end=0;
        for(int[] interval: intervals){
            if(prev_end>interval[0]){
                return false;
            }
            prev_end=interval[1];
        }
        return true;
    }
}