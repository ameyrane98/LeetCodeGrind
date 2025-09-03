class Solution {
    public int findPeakElement(int[] nums) {
        /**

         */
        int currPeak=-1;
        if(nums.length==1){
            return 0;
        }

        for(int i=0; i<nums.length; i++){

            int left = (i==0)? Integer.MIN_VALUE:nums[i-1];
            int right = (i==nums.length-1)? Integer.MIN_VALUE:nums[i+1];

           
            if(left<nums[i] && right< nums[i]){
                    currPeak=i;
                    break;
            }
            
        }

        return currPeak;
    }

}