import java.util.Arrays;

class Solution {
    /** Top Down Approach */
    /** Recursion + Memoization (n^2) */
    /** Recursion by itself (2^n)  */
    // public int lengthOfLIS(int[] nums) {
    //     Integer[][] dp = new Integer[nums.length][nums.length+1];
    //      // Initialize dp with 1, because each element is a subsequence of length 1
    
    //     return solve(nums,nums.length,0,-1,dp);
    // }

    // int solve(int[] nums,int n, int start, int prev,Integer[][] dp){
    //     if(start>=n){
    //         return 0;
    //     }
    //     if (dp[start][prev + 1] != null) return dp[start][prev + 1];

    //     int skip =solve(nums,n,start+1,prev,dp);
        
    //     int take=0;
    //     if(prev==-1 || nums[prev]<nums[start]){
    //         take =1+solve(nums,n,start+1,start,dp);
    //     }
           
    //      dp[start][prev + 1] = Math.max(take, skip);
    //     return dp[start][prev + 1];
    // }



    /** Bottom up Approach */
    // https://www.youtube.com/watch?v=h9rm4N8XbL0&list=PLpIkg8OmuX-JhFpkhgrAwZRtukO0SkwAt&index=12&ab_channel=codestorywithMIK


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);  // Initialize dp with 1, because each element is a subsequence of length 1
        
        // Iterate through each element in the array
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {  // If nums[i] can extend the subsequence ending at nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // Update dp[i] with the longest subsequence ending at i
                }
            }
        }

        // The longest increasing subsequence will be the maximum value in dp array
        return Arrays.stream(dp).max().getAsInt();
    
}


}
