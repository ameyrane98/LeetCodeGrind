// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         if (n == 0) return 0;

//         int[][][] memo = new int[n][3][2]; // 2 transactions max => transactionsLeft: 0..2
//         for (int i = 0; i < n; i++) {
//             for (int t = 0; t <= 2; t++) Arrays.fill(memo[i][t], Integer.MIN_VALUE);
//         }
//         return solve(0, 2, 0, prices, memo);
//     }

//     // day: current index
//     // t: how many sells (transactions) left
//     // hold: 0 = not holding, 1 = holding
//     private int solve(int day, int t, int hold, int[] prices, int[][][] memo) {
//         if (day == prices.length || t == 0) return 0;

//         if (memo[day][t][hold] != Integer.MIN_VALUE) return memo[day][t][hold];

//         // Option 1: do nothing today
//         int best = solve(day + 1, t, hold, prices, memo);

//         if (hold == 0) {
//             // Option 2: buy today (doesn't consume a transaction yet)
//             best = Math.max(best, -prices[day] + solve(day + 1, t, 1, prices, memo));
//         } else {
//             // Option 2: sell today (consumes 1 transaction)
//             best = Math.max(best, prices[day] + solve(day + 1, t - 1, 0, prices, memo));
//         }

//         memo[day][t][hold] = best;
//         return best;
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int p : prices) {
            buy1 = Math.max(buy1, -p);        // buy first stock
            sell1 = Math.max(sell1, buy1 + p); // sell first stock

            buy2 = Math.max(buy2, sell1 - p);  // buy second stock (after 1st sell)
            sell2 = Math.max(sell2, buy2 + p); // sell second stock
        }

        return sell2;
    }
}
