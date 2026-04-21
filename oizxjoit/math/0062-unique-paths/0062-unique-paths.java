class Solution {
    public int uniquePaths(int m, int n) {
        /**
            [
                robot,  0 ,
                0,  0
                0, target (2,2)
            ]

            right (n-1) down (m-1) 2+1 =3
         */

        int[][] dp = new int[m][n];


        for(int i=0; i<m; i++){
            dp[i][0]=1;
        }
        for(int j=0; j<n; j++){
            dp[0][j]=1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}