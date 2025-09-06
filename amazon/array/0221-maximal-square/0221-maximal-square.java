class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max=0;
        int[][] memo= new int[m][n];
        for(int[] row : memo) Arrays.fill(row,-1);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1'){
                    max=Math.max(max,solve(matrix,i,j,memo)*solve(matrix,i,j,memo));
                }
            }
        }

        return max;
    }

    public int solve(char[][] matrix, int i ,int j,int[][] memo){
        int m = matrix.length;
        int n = matrix[0].length;
        if(i>=m || j>=n){
            return 0;
        }

        if(matrix[i][j]=='0'){
            return 0;
        }

        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int right = solve(matrix,i,j+1,memo);
        int bottom = solve(matrix,i+1,j,memo);
        int dia = solve(matrix,i+1,j+1,memo);


        return memo[i][j]=1+Math.min(right,Math.min(dia,bottom));
    }
}