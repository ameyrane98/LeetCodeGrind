class Solution {
        int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp= new int[amount+1];
        Arrays.fill(dp,-1);
        int result= dfs(coins,amount);
     
        return result==Integer.MAX_VALUE ? -1: result; 
    
    }

    public int dfs(int[] coins,int rem){
        if(rem==0){
            return 0;
        }

        if(rem<0){
            return Integer.MAX_VALUE;
        }
        if(dp[rem]!=-1){
            return dp[rem];
        }
        int minCoins=Integer.MAX_VALUE;

        for(int coin: coins){
            int result=dfs(coins,rem-coin);
            if(result!=Integer.MAX_VALUE){
                minCoins= Math.min(minCoins,1+result);
            }
        }

        dp[rem] = minCoins; // Store computed result
        return dp[rem];
    }


    /**Bottom up approach */

  

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1); // Fill with a large value
//         dp[0] = 0; // Base case: 0 coins needed to make amount 0

//         // Iterate through each amount
//         for (int i = 1; i <= amount; i++) {
//             for (int coin : coins) {
//                 if (i >= coin) {
//                     dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                 }
//             }
//         }

//         return dp[amount] > amount ? -1 : dp[amount];
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] coins = {1, 2, 5};
//         int amount = 11;
//         System.out.println(solution.coinChange(coins, amount)); // Output: 3
//     }
// }

}