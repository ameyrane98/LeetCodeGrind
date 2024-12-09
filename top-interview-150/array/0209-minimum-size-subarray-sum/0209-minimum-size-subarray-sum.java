class Solution {
    int maxLength=Integer.MAX_VALUE;
   public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        for(int right=0; right<nums.length;right++){
            sum+=nums[right];

            while(sum>=target){
                maxLength=Math.min(maxLength, right-left+1);
                sum-=nums[left];
                left++;
            }
        }

        return  maxLength==Integer.MAX_VALUE ? 0: maxLength;
   }


    //O(n^2)
    // int maxLength=Integer.MAX_VALUE;
    // public int minSubArrayLen(int target, int[] nums) {

    //     for(int i=0; i<nums.length; i++){
    //         subArrrySum(i,i,nums,0,target);
    //     }

    //    return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
    // }

    // void subArrrySum(int i, int j,int[] nums,int sum,int target){

    //     while(j<nums.length){
    //         sum+=nums[j];// add j

    //         if(sum>=target){ // check if it equal or greater than target
    //             int[] sub = Arrays.copyOfRange(nums, i, j); 
             
    //             maxLength=Math.min(j-i+1,maxLength);
    //             i=j;
    //             return;
    //         }
    //         // else move j ahead
    //         j++;
    //     }

    // }
}