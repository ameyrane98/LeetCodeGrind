class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    public int binarySearch(int[] nums, int low, int high, int target){
        if(high>=low){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                return mid;
            }
            // right half is sorted
            if(nums[high] >= nums[mid]){
                if(nums[mid]<= target && nums[high] >= target){
                    return binarySearch(nums,mid+1,high,target);
                }else{
                    return binarySearch(nums,low,mid-1,target);
                }
            }else{
                if(nums[mid]>= target && nums[low] <= target){
                    return binarySearch(nums,low,mid-1,target);
                  
                }else{
                    return binarySearch(nums,mid+1,high,target);
                }
            }
            

            
        }else{
            return -1;
        }

       
    }
}