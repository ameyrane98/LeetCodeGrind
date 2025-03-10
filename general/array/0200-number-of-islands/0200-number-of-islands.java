class Solution {
    public int numIslands(char[][] grid) {
        int cols= grid[0].length;
        int row= grid.length;
        boolean[][] visited= new boolean[row][cols];
        int count=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        
        return count;
    }

    void dfs(char[][] grid, int row, int col,  boolean[][] visited){

        if(row<0 || col <0 || col >= grid[0].length || row >= grid.length || grid[row][col]=='0' || visited[row][col]){
            return;
        }

        visited[row][col]=true;

        dfs(grid,row-1, col, visited);
          dfs(grid,row, col+1, visited);
            dfs(grid,row+1, col, visited);
              dfs(grid,row, col-1, visited);
    }

}