import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
         // Initialize dp with 1, because each element is a subsequence of length 1
    
        return solve(nums,nums.length,0,-1,dp);
    }

    int solve(int[] nums,int n, int start, int prev,Integer[][] dp){
        if(start>=n){
            return 0;
        }
        if (dp[start][prev + 1] != null) return dp[start][prev + 1];

        int skip =solve(nums,n,start+1,prev,dp);
        
        int take=0;
        if(prev==-1 || nums[prev]<nums[start]){
            take =1+solve(nums,n,start+1,start,dp);
        }
           
         dp[start][prev + 1] = Math.max(take, skip);
        return dp[start][prev + 1];
    }
}
