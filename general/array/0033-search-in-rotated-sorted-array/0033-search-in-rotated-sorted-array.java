class Solution {
    public int search(int[] nums, int target) {
        return bs(nums,0,nums.length-1,target);
    }

    int bs(int[] nums, int low, int high, int target){
        if(low<=high){
            int mid= low + (high-low)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>=nums[low]){
                //left half is sorted
                if(nums[mid]>=target && nums[low]<=target){
                    return bs(nums,low,mid,target);
                }else{
                    return bs(nums,mid+1,high,target);
                }
            }else{
                if(nums[mid]<=target && nums[high]>=target){
                    return bs(nums,mid+1,high,target);
                 
                }else{
                    return bs(nums,low,mid,target);
                }
            }
        
        
        }

       return -1;
    }
}