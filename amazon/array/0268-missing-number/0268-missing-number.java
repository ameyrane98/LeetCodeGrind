class Solution {
    public int missingNumber(int[] nums) {
         // T: O(n), S= O(n)
        int n = nums.length;
        // boolean[] present = new boolean[n + 1]; // range 0..n

        // for (int num : nums) {
        //     present[num] = true;
        // }

        // for (int i = 0; i <= n; i++) {
        //     if (!present[i]) {
        //         return i;
        //     }
        // }

        // return -1; // should never happen if input is valid

        // S=O(1)

        int sumOfN= n*(n+1)/2;

        for(int i=0; i<nums.length; i++){
            sumOfN=sumOfN-nums[i];
        }

        return sumOfN;
    }
}
