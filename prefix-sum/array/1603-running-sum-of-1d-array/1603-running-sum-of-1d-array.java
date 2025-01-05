class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] preSum= new int[n];
        preSum[0]=nums[0];
        for(int i=1; i<n ; i++){
            preSum[i]=preSum[i-1]+nums[i];
        }

        return preSum;
    }
}