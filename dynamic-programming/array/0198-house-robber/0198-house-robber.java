class Solution {
    int[] t = new int[100];
    public int rob(int[] nums) {
        Arrays.fill(t,-1);
        return solve(nums,0);
    }

    public int solve(int[] nums, int i){

        if(i>=nums.length){
            return 0;
        }
        if(t[i]!=-1){
            return t[i];
        }

       int steal=nums[i]+solve(nums,i+2);
        int skip= solve(nums,i+1);

        return t[i]=Math.max(steal,skip);
    }
}