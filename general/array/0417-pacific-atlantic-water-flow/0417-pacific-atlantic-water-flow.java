class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();
        
        // Perform DFS from Pacific (left and top borders) and Atlantic (right and bottom borders)
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);         // Left border (Pacific)
            dfs(heights, atlantic, i, cols - 1, Integer.MIN_VALUE);  // Right border (Atlantic)
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);         // Top border (Pacific)
            dfs(heights, atlantic, rows - 1, j, Integer.MIN_VALUE); // Bottom border (Atlantic)
        }

        // Find cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int rows = heights.length, cols = heights[0].length;
        
        // Boundary conditions: out of bounds, already visited, or cannot flow uphill
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;  // Mark cell as visited
        
        // Directions for DFS traversal (Up, Down, Left, Right)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            dfs(heights, visited, i + dir[0], j + dir[1], heights[i][j]);
        }
    }
}
