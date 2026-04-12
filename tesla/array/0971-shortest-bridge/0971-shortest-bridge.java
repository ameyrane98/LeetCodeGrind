class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        Queue<int[]> que= new LinkedList<>();
        int distance =0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j]=-1;
            }
        }

        outer:
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && visited[i][j]==-1){
                    // do bfs explore wide
                   dfs(grid,i,j,n,visited,que);
                   break outer;
                }
            }
        }

       while (!que.isEmpty()) {
    int size = que.size(); // ← snapshot of current wave size
    
    for (int k = 0; k < size; k++) { // ← process entire wave
        int[] point = que.remove();
        int ci = point[0];
        int cj = point[1];
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : dirs) {
            int ni = ci + dir[0];
            int nj = cj + dir[1];
            
            if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue; // out of bounds
            if (visited[ni][nj] == 2) continue;                    // already seen
            if (grid[ni][nj] == 1) return distance;                // 🎯 Island 2 found!
            
            visited[ni][nj] = 2;                                   // mark water as visited
            que.add(new int[]{ni, nj});
        }
    }
    distance++; // ← wave complete, one more flip needed
}

return distance;


        
    }

    void dfs(int[][]grid, int i, int j, int n, int[][]visited, Queue<int[]> que){
        
        if( j>=n || i>=n || i<0 || j <0 || visited[i][j]== 2 || grid[i][j]==0 ){
            return;
        }
        
        visited[i][j]=2;
        que.add(new int[]{i,j});

        dfs(grid,i+1,j,n,visited,que);
        dfs(grid,i-1,j,n,visited,que);
        dfs(grid,i,j+1,n,visited,que);
        dfs(grid,i,j-1,n,visited,que);

    }

   
}