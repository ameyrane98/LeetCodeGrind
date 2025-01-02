class Solution {
    public int findMin(int[] nums) {
        return bs(nums,0,nums.length-1);
    }

    int bs(int[] nums,int left, int right){
        while(left<right){
            int mid= left+ (right-left)/2;

            if(nums[mid]>=nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
            
        }

        return nums[left];
    }
}