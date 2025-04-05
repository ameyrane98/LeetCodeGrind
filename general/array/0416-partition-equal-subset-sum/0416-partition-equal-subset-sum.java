class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false; // Odd total can't be split equally

        int target = total / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return solve(nums, 0, 0, target, dp);
    }

    public boolean solve(int[] nums, int i, int sum, int target, Boolean[][] dp) {
        if (sum == target) return true;
        if (sum > target || i == nums.length) return false;

        if (dp[i][sum] != null) return dp[i][sum];

        boolean take = solve(nums, i + 1, sum + nums[i], target, dp);
        boolean skip = solve(nums, i + 1, sum, target, dp);

        dp[i][sum] = take || skip;
        return dp[i][sum];
    }
}
