class Solution {
    public boolean canJump(int[] nums) {
        return solve(nums, 0, nums[0], nums.length - 1);
    }

    public boolean solve(int[] nums, int idx, int jump, int targetIdx) {
        if (idx >= nums.length || jump < idx) {
            return false;
        }

        if (jump >= targetIdx) {
            return true;
        }

        return solve(nums, idx + 1, Math.max(jump, idx + nums[idx]), targetIdx);
    }
}
