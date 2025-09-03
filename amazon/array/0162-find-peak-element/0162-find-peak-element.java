class Solution {
    public int findPeakElement(int[] nums) {
        /**
            O(n) way
         */
        // int currPeak=-1;
        // if(nums.length==1){
        //     return 0;
        // }

        // for(int i=0; i<nums.length; i++){

        //     int left = (i==0)? Integer.MIN_VALUE:nums[i-1];
        //     int right = (i==nums.length-1)? Integer.MIN_VALUE:nums[i+1];

           
        //     if(left<nums[i] && right< nums[i]){
        //             currPeak=i;
        //             break;
        //     }
            
        // }

        // return currPeak;

         /**
            O(log n) way binary Search
         */

        int l=0; int r= nums.length-1;

        while(l<r){
            int m = l+(r-l)/2;

            if(nums[m]<nums[m+1]){
                //peak is in the right half;
                l=m+1;
            }else{
                r=m; // peak is in the left half;
            }
        }


        return l;
    }

}