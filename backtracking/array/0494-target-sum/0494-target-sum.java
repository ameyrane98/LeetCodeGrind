class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        solve(nums,target,0);

        return count;
    }

    void solve(int[] nums, int target, int idx){
        if(idx==nums.length){
             if(target==0){
                    count++;
                }
            return;
        }

    
        solve(nums,target-nums[idx],idx+1);
        solve(nums,target+nums[idx],idx+1);
    }


}