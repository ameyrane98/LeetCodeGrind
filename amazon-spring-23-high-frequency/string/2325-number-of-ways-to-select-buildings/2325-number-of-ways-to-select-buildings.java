class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long[][] dp = new long[4][3];  // dp[k][lastChar]: k = how many picked, lastChar = 0/1/none(2)

        dp[0][2] = 1; // Base case: 0 picked, no last char

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int curr = c - '0';
            long[][] next = new long[4][3];

            for (int k = 0; k <= 3; k++) {
                for (int last = 0; last <= 2; last++) {
                    // Skip current character
                    next[k][last] += dp[k][last];

                    // Pick current character if different from last one
                    if (k < 3 && (last == 2 || last != curr)) {
                        next[k + 1][curr] += dp[k][last];
                    }
                }
            }
            dp = next;
        }

        // Return total ways to pick 3 characters ending in either 0 or 1
        return dp[3][0] + dp[3][1];
    }
}
