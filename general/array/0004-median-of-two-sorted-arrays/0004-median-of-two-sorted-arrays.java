class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m= nums1.length; int n= nums2.length;
        int[] newarr= new int[m+n];
        int newIdx=0;

        for(int i=0; i<m; i++){
            newarr[newIdx++]=nums1[i];
        }

        
        for(int i=0; i<n; i++){
            newarr[newIdx++]=nums2[i];
        }

        Arrays.sort(newarr);
        
        int mid=newarr.length/2;
        if(newarr.length%2!=0){
            return newarr[mid];
        }
        System.out.println(newarr[mid-1]);

        return (double) (newarr[mid-1]+newarr[mid]) / 2;
    }
}