class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0; int high = nums.length-1;

        while(low < high){
            int mid = (high+low)/2;

            if(mid%2 == 1) mid--; // set it to even if mid id odd;

            if(nums[mid] == nums[mid+1]){
                low=mid+2;
            }else{
                high=mid;
            }


        }

        return nums[low];
    }
}