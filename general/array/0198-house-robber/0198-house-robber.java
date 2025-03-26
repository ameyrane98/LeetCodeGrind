class Solution {
    int[] memo;
    public int rob(int[] nums) {
        /** think about robbing the housr or skipping it */
        int n = nums.length;
        memo= new int[n];

        Arrays.fill(memo,-1);

        return solve(nums,0);
    }

    public int solve(int[] nums,int i){
        if(i>=nums.length){
            return 0;
        }

        if(memo[i]!=-1){
            return memo[i];
        }

        int rob= nums[i]+ solve(nums,i+2);
        int skip= solve(nums,i+1);
        memo[i]=Math.max(skip,rob);

        return memo[i];
    }
}