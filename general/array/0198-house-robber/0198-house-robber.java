class Solution {
    public int rob(int[] nums) {
        /**
            for every idx either we take the value, or we dont;
            only ehcek id that wer should not take adjacnet vvalue

         */
         Integer[] memo = new Integer[nums.length];
         return solve(nums,nums.length,0, memo);
    }

    public int solve(int[] nums, int n, int idx, Integer[] memo){
        if(idx>=n){
            return 0;
        }
        if (memo[idx] != null) return memo[idx]; 

        int take=nums[idx]+solve(nums,n, idx+2, memo);

        int skip= solve(nums,n, idx+1,memo);

        return memo[idx]=Math.max(take,skip);
    }
}