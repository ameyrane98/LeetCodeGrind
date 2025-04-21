class Solution {
    public int jump(int[] nums) {
        // Start from index 1 because we already "used" the first jump from index 0
        if (nums.length == 1) return 0; // No jumps needed if only one element
        return solve(nums, 1, nums[0], nums.length - 1, 1);
    }

    public int solve(int[] nums, int idx, int jump, int targetIdx, int minJump) {
        // Base case 1: if current reach (jump) has already reached or passed the target
        if (jump >= targetIdx) {
            return minJump;
        }

        // Base case 2: if idx has gone beyond current jump range, time to increase jump count
        if (idx > jump) {
            // make a jump and reset jump range to the best possible so far
            return solve(nums, idx, idx + nums[idx], targetIdx, minJump + 1);
        }

        // Continue scanning: update max reach within the current jump range
        int newJump = Math.max(jump, idx + nums[idx]);

        // Recurse to the next index
        return solve(nums, idx + 1, newJump, targetIdx, minJump);
    }
}
