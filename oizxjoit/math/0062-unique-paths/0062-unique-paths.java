class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int i =0; i<n; i++){
            dp[i]=1;
        }

       // After each outer iteration, dp[] represents that row's path counts
        for (int i = 1; i < m; i++) {
            // dp[0] stays 1 — first column always has one path (walk down)
            // So we start j at 1
            for (int j = 1; j < n; j++) {
                // BEFORE this line:
                //   dp[j]   = value from row above  (i.e., dp[i-1][j])
                //   dp[j-1] = value from current row, left cell (i.e., dp[i][j-1])
                // Equivalent to: dp[i][j] = dp[i-1][j] + dp[i][j-1]
                dp[j] = dp[j] + dp[j-1];
            }
        }
        
        // Step 3: Last cell holds the answer (bottom-right of the conceptual 2D grid)
        return dp[n-1];
    }
}