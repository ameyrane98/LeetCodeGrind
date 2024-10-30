class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Step 1: Find the majority candidate
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // Step 2 (Optional): Verify the candidate if needed
        // This step is not strictly necessary if we assume the array always has a majority element.

        return candidate;
    }
}
