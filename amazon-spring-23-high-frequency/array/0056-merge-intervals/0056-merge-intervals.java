class Solution {
    public int[][] merge(int[][] intervals) {
        /**O(n log n) */
       Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
       int[][] out= new int[intervals.length][2];
       out[0][0]=intervals[0][0];
       out[0][1]=intervals[0][1];
        int index=0;  // not keeping track of where to merger next array;

        for(int i=1; i<intervals.length; i++){
            int start= intervals[i][0];
            int end= intervals[i][1];

             if (start <= out[index][1]) {
                out[index][1] = Math.max(out[index][1], end); // Merge
            } else {
                index++; // Move to next slot
                out[index][0] = start;
                out[index][1] = end;
            }

            
        }

         return Arrays.copyOf(out, index + 1);
    }
}