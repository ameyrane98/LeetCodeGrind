class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            if(target== nums[i]){
                int left=i;
                int right=i;
               while (right + 1 < nums.length && nums[right + 1] == target) {
                    right++;
                }
                return new int[]{left,right};
            }
        }

        return new int[]{-1,-1};
    }
}