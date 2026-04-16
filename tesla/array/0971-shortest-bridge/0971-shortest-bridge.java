class Solution {
    Queue<int[]> que = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // Step 1: Find and mark the first island via DFS
        outer:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, i, j, n, visited);
                    break outer;
                }
            }
        }

        // Step 2: BFS level-by-level from all first-island cells
        int distance = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!que.isEmpty()){
            int size = que.size();
            for(int k = 0; k < size; k++){
                int[] coord = que.poll();
                for(int[] ci : dir){
                    int x = coord[0] + ci[0];
                    int y = coord[1] + ci[1];
                    if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) continue;
                    if(grid[x][y] == 1) return distance;
                    visited[x][y] = true;
                    que.offer(new int[]{x, y});
                }
            }
            distance++;
        }

        return -1; // unreachable if input is valid
    }

    void dfs(int[][] grid, int i, int j, int n, boolean[][] visited){
        if(i >= n || j >= n || i < 0 || j < 0 
           || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;
        que.offer(new int[]{i, j});

        dfs(grid, i-1, j, n, visited);
        dfs(grid, i+1, j, n, visited);
        dfs(grid, i, j+1, n, visited);
        dfs(grid, i, j-1, n, visited);
    }
}