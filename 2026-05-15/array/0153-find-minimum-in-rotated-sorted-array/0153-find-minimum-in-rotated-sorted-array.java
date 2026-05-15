class Solution {
    public int findMin(int[] nums) {
        /**
            binarySearch(nums,low,high)

            Intially bS(nums,0,n-1)

            mid = low+(high-low)/2

            if nums[low]>nums[mid] or nums[high]<nums[mid]:
                the array is rotated
                we have to try finding 
                try to find min in right side:
            if not rotated we try to find min in left side
         */

        int n = nums.length;

        return bS(nums,0,n-1);
    }

    int bS(int[] nums, int low, int high){
        if(low>=high){
            return nums[low];
        }

        int mid = low + (high-low)/2;

        if(nums[high]<nums[mid]){
            // means array is rotated
            // [high number , mid , low number] ->[5,1,2,3,4]
            // because we want to find the minimum
            // we take look at right
            return bS(nums,mid+1,high);
        }else{
            return bS(nums,low,mid);
        }

        
    }
}