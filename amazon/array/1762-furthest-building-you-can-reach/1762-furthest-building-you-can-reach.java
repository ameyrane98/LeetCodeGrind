class Solution {
    PriorityQueue<Integer> max_heap= new PriorityQueue<>(Collections.reverseOrder());
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        /** Naive Solution */
        // int n = heights.length;
        // for (int i = 0; i < n - 1; i++) {
        //     int climb = heights[i + 1] - heights[i];
        //     if (climb <= 0) continue;  // no resources needed

        //     if (bricks >= climb) {
        //         // use bricks if we have enough
        //         bricks -= climb;
        //     } else if (ladders > 0) {
        //         // not enough bricks → use ladder on this climb
        //         ladders--;
        //     } else {
        //         // can't cover this climb → stop
        //         return i;
        //     }
        // }
        // // reached the end
        // return n - 1; 


        /**Optimal Solution */

    int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            
            if(climb<0) continue;

           
            bricks-=climb;
            max_heap.offer(climb);
            

            if(bricks<0){
                if(ladders>0){
                    ladders-=1;
                    bricks+=max_heap.poll();
                }else{
                    return i;
                }
            }
            
        }

        return n-1;
    }
}