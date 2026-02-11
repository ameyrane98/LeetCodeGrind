class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[]{-1,-1};
        ans[0]=first(0,nums.length-1,nums,target);
        ans[1]=last(0,nums.length-1,nums,target);
        return ans;
    }

    public int first(int left,int right, int[] nums, int target){
        if(left>right) return -1;
      int mid = left + (right - left) / 2;

        if(nums[mid]==target){
            int leftResult = first(left, mid - 1, nums, target);
            return (leftResult == -1) ? mid : leftResult;

        }

        if(nums[mid]>target){
            return first(left,mid-1,nums,target);
        }

        
        return first(mid+1,right,nums,target);
        

       
    }


     public int last(int left,int right, int[] nums, int target){
        if(left>right) return -1;
    int mid = left + (right - left) / 2;

        if(nums[mid]==target){
            int rightResult = last(mid+1, right , nums, target);
            return (rightResult == -1) ? mid : rightResult;

        }

        if(nums[mid]>target){
            return last(left,mid-1,nums,target);
        }

            return last(mid+1,right,nums,target);
      

       
    }
}