class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)return findMedianSortedArrays(nums2,nums1);

        int m = nums1.length;
        int n= nums2.length;

        int low=0; int high= m;

        while(low<=high){
            int pX=  low + (high - low) / 2;
            int pY= ((m+n+1)/2)-pX;

            int x1= (pX==0) ? Integer.MIN_VALUE: nums1[pX-1]; 
            int x2= (pY==0) ? Integer.MIN_VALUE:nums2[pY-1];
            int x3= (pX==m) ? Integer.MAX_VALUE:nums1[pX];
            int x4= (pY==n) ? Integer.MAX_VALUE:nums2[pY];

            if(x1<=x4 && x2<=x3){
              if( ((m+n) % 2) == 0){
                    // even res arr 
                    return (((double)Math.max(x1, x2)) + Math.min(x3, x4)) / 2.0;
                }else{
                    return Math.max(x1,x2);
                }
            } else if(x1>x4){
                high=pX-1;
            }else{
                low=pX+1;
            }

        }

        throw new IllegalArgumentException("Inputs must be sorted.");
    }
}