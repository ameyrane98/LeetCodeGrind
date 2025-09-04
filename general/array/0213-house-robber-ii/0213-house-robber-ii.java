class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // Case A: houses [0..n-2]
        Integer[] memoA = new Integer[n];
        int a = solve(nums, 0, n - 2, memoA);
        // Case B: houses [1..n-1]
        Integer[] memoB = new Integer[n];
        int b = solve(nums, 1, n - 1, memoB);
        return Math.max(a, b);
    }

    // Best we can do starting at i within [l..r] (inclusive)
    private int solve(int[] nums, int i, int r, Integer[] memo) {
        if (i > r) return 0;
        if (memo[i] != null) return memo[i];
        int take = nums[i] + solve(nums, i + 2, r, memo);
        int skip = solve(nums, i + 1, r, memo);
        return memo[i] = Math.max(take, skip);
    }
}
