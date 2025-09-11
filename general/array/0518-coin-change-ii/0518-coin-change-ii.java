class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n][amount + 1];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return dfs(amount, coins, 0, memo);
    }

    private int dfs(int rem, int[] coins, int idx, int[][] memo) {
        if (rem == 0) return 1;          // one valid combination
        if (rem < 0 || idx == coins.length) return 0;  // no way
        if (memo[idx][rem] != -1) return memo[idx][rem];

        // take (stay at idx) + skip (move to next)
        int take = dfs(rem - coins[idx], coins, idx, memo);
        int skip = dfs(rem, coins, idx + 1, memo);

        return memo[idx][rem] = take + skip;
    }
}