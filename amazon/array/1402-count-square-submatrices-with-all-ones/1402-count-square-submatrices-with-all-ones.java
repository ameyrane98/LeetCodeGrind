class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo= new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int result=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
              
                if(matrix[i][j]==1){
                    result+=solve(matrix,i,j,memo);
                }
            }
        }

        return result;
    }

    public int solve(int[][] grid, int i , int j,int[][] memo){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=m ||j>=n){
            return 0;
        }

        if(grid[i][j]==0){
            return 0;
        }

        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        int right = solve(grid,i,j+1,memo);
        int dia = solve(grid,i+1,j+1,memo);
        int bottom = solve(grid,i+1,j,memo);

        return memo[i][j]=1+Math.min(Math.min(right,dia),bottom);
    }

}