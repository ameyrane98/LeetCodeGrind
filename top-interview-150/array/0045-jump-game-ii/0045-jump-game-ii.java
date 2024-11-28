class Solution {
     public int jump(int[] nums) {
        if (nums.length <= 1) return 0; // No jumps needed if already at the last index
        
        int maxReach = 0;    // The farthest index that can be reached
        int currentEnd = 0;  // The end of the current jump range
        int jumps = 0;       // Number of jumps taken
        
        for (int i = 0; i < nums.length - 1; i++) { // Traverse until the second-last index
            maxReach = Math.max(maxReach, i + nums[i]); // Update the farthest reachable index
            
            if (i == currentEnd) { // If we reach the end of the current jump range
                jumps++;           // Increment jump count
                currentEnd = maxReach; // Update the range for the next jump
                
                if (currentEnd >= nums.length - 1) { // If we can reach the last index, stop
                    break;
                }
            }
        }
        
        return jumps;
    }
}