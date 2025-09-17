class Solution {

    public int fib(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n, int[] dp){
        if(n==0){
            dp[0]=0;
        }

        if(n==1){
            dp[1]=1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n]=fib(n-1)+fib(n-2);
    }
}