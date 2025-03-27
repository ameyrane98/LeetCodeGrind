class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Edge case: Only one house

        return Math.max(solve(nums,0,n-2), solve(nums,1, n-1));
    }

    int solve(int[] nums,int start, int end){
      int[] memo= new int[ nums.length];
        Arrays.fill(memo,-1);
      return dp(nums,start,end,memo);
    }  

    int dp(int[] nums, int i, int end,int[] memo){
        if(i>end){
            return 0;
        }

        if(memo[i]!=-1){
            return memo[i];
        }

        int rob= nums[i] + dp(nums,i+2, end, memo);
        int skip= dp(nums,i+1, end, memo);

        memo[i]= Math.max(skip,rob);

        return memo[i];
    }
} 