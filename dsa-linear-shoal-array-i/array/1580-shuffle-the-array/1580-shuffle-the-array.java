class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int idx=0;
        for(int i =0; i<n; i++){
            ans[idx]=nums[i];
            idx+=2;
        }
        idx=1;
        for(int i =n; i<nums.length; i++){
            ans[idx]=nums[i];
            idx+=2;
        }

       return ans;
    }
}