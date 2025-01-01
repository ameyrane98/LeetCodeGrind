class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums : matrix){
            if(bs(nums,0,nums.length,target)){
                return true;
            }
        }

        return false;
    }

    boolean bs(int[] nums,int low, int high, int target){

        while(low<high){
            int mid= low + (high-low)/2;

            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                return bs(nums,low,mid,target);
            }else{
                return bs(nums,mid+1,high,target);
            }
        }

        return false;
    }
}