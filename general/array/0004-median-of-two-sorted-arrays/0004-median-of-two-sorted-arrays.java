class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for binary search optimization
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            // Handle edge cases where partition index is at the boundary
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total length is odd, return max of left partition
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                }
                // If even, return the average of the two middle elements
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;  // Move towards left in nums1
            } else {
                low = partitionX + 1;   // Move towards right in nums1
            }
        }

        // Should never reach here for valid inputs
        throw new IllegalArgumentException("Input arrays are not valid.");
    }
}
