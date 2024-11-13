class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp= new int[n+1];
        Arrays.fill(dp,-1);
       return solve(n);
    }


 public int solve(int n){
        if(n<0){
            return 0;
        }
        if(dp[n] !=-1){
            return dp[n];
        }

        if(n==0){
            return 1;
        }

        int one_step=solve(n-1);
        int two_step=solve(n-2);

        return dp[n]=one_step+two_step;
    }

    //  /**Brue force 2^n*/
    // public int climbStairs(int n) {

    //    return solve(n);
    // }
  
    // public int solve(int n){
    //     if(n<0){
    //         return 0;
    //     }

    //     if(n==0){
    //         return 1;
    //     }

    //     int one_step=climbStairs(n-1);
    //     int two_step=climbStairs(n-2);

    //     return one_step+two_step;
    // }
}