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
}