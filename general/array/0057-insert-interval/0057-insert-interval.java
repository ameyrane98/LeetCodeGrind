class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        boolean merged=false;
        
        for(int i=0; i< intervals.length; i++){
            int start= intervals[i][0];
            int end= intervals[i][1];
            if(newInterval[1]<start){
                // new intervals if
                if(!merged){
                    result.add(newInterval);
                    merged=true;
                    
                } 
                result.add(intervals[i]);

            }else if(newInterval[0]>end){
                result.add(intervals[i]);
            }else{
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
                // Don’t add yet — will add once no more overlap
            }
           
        }

        if (!merged) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }
}