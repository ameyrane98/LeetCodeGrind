import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int freshCount = 0, minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        // Step 1: Add all initially rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Add rotten orange position
                } else if (grid[i][j] == 1) {
                    freshCount++;  // Count fresh oranges
                }
            }
        }

        // Edge case: If there are no fresh oranges, return 0
        if (freshCount == 0) return 0;

        // Step 2: Perform BFS level by level
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++; // Increment time after each level

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Step 3: Check bounds and if it's a fresh orange
                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rotten the fresh orange
                        queue.offer(new int[]{newX, newY});
                        freshCount--; // Reduce fresh orange count
                    }
                }
            }
        }

        // Step 4: If there are still fresh oranges, return -1
        return freshCount == 0 ? minutes : -1;
    }
}
