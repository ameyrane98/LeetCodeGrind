class Solution {
    private static final int INF = 1000000000;
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int n =coins.length;
        int[][] memo= new int[n][amount+1];
        for(int[] mem : memo){ Arrays.fill(mem,-1);};
        int res= solve(coins,amount,0,n,memo);
        return (res >= INF) ? -1 : res;
    }

    public int solve(int[] coins,int amount,int idx, int n,int[][] memo){
        if(amount==0){
            return 0;
        }

        if (amount < 0) return INF; // infinity
        if (idx == n) return INF;// infinity
        
        if (memo[idx][amount] != -1) return memo[idx][amount];

        int take = 1 + solve(coins,amount-coins[idx],idx,n,memo);

        int skip = solve(coins,amount,idx+1,n,memo);


       return memo[idx][amount] = Math.min(take,skip);
    }
}