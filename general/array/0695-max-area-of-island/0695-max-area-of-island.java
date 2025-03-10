class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row= grid.length;
        int cols= grid[0].length;
        int maxArea=0;
    
        boolean[][] visited= new boolean[row][cols];
        for(int i=0; i< row; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area=dfs(grid,i, j, visited);
                    System.out.println(area);
                    maxArea=Math.max(maxArea,area);
                }
            }
          ;
        }

        return maxArea;
    }

    int dfs(int[][] grid, int row, int col,boolean[][] visited){
        
        if(row<0 || col <0 || col>= grid[0].length || row>= grid.length || grid[row][col]==0 || visited[row][col]){
            return 0;
        }
        visited[row][col]=true;
        int area=1;

        area+=dfs(grid,row+1,col,visited);
        area+=dfs(grid,row-1,col,visited);
        area+=dfs(grid,row,col+1,visited);
        area+=dfs(grid,row,col-1,visited);

        return area;
    }
}