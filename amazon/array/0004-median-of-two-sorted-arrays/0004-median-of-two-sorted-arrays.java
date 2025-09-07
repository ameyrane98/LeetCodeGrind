class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);

        int m = nums1.length;
        int n = nums2.length;
        int low =0; int high=m;

        while(low<=high){
            int mid = (low+ high)/2;
            int partitionX = mid;
            int partitionY = (m+n+1)/2-partitionX;

            int x1 = (partitionX==0) ? Integer.MIN_VALUE: nums1[partitionX-1];
            int x2= (partitionY==0) ? Integer.MIN_VALUE: nums2[partitionY-1];
            int x3= (partitionX==m) ? Integer.MAX_VALUE: nums1[partitionX];
            int x4= (partitionY==n) ? Integer.MAX_VALUE:nums2[partitionY];

            if(x1<=x4 && x2<= x3){
                if((m+n)%2 == 0){
                    // even res arr 
                    return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
                }else{
                    return Math.max(x1,x2);
                }
            }else if(x1>x4){
                high=partitionX-1;
            }else{
                low=partitionX+1;
            }
            
        }
        
        return -1;
    }
}