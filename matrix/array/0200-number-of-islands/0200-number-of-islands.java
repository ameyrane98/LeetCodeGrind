class Solution {
    int result=0;
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]=='1'){
                    if(dfs(grid,i,j,m,n)){
                        result++;
                    };
                    
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] grid,int i,int j,int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0'){
            return false;
        }

        grid[i][j]='0';


        dfs(grid,i+1,j,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j-1,m,n);

        return true;
    }
}