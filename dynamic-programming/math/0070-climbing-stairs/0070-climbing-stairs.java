class Solution {
  /**Another way */
    public int climbStairs(int n) {
        return solve(n);
    }

    public int solve(int n){

        if(n<=2){
            return n;
        }

        int a=1;
        int b=2;
        int c=3;
        for(int i=3;i<=n;i++)
        {
            c=b+a;

            int temp_b=b;
            b=c;
            a=temp_b;

        }

        return c;
    }


    /**Bottom up Appraoch */
    //int[] numArr;// numebr of ways to clim ith stairs, i.e 2 stair chadne ke kitne ways hai

    // public int climbStairs(int n) {
    //     numArr= new int[n+1];
    //     Arrays.fill(numArr,-1);
    //     return solve(n,numArr);
    // }

    // public int solve(int n,int[] numArr){

    //     if(n<=2){
    //         return n;
    //     }

    //     numArr[0]=0;// Number of ways to climb ith stairs
    //     numArr[1]=1;// Number of ways to climb ith stairs
    //     numArr[2]=2;// Number of ways to climb ith stairs

    //     for(int i=3;i<=n;i++)
    //     {
    //         numArr[i]= numArr[i-2]+numArr[i-1];
    //     }

    //     return numArr[n];
    // }

    /**Top Down Approach */
    // int[] dp;
    // public int climbStairs(int n) {
    //     dp= new int[n+1];
    //     Arrays.fill(dp,-1);
    //    return solve(n);
    // }

    // public int solve(int n){
    //     if(n< 0){
    //         return 0;
    //     }

    //     if(dp[n] != -1){
    //         return dp[n];
    //     }

    //     if(n == 0){
    //         return 1;
    //     }

    //     int oneStep= solve(n-1);
    //     int twoStep= solve(n-2);

    //     return dp[n] = oneStep + twoStep;
    // }






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