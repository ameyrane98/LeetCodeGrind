class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};
        dfs(matrix, 0, 0, m, n, visited, res, dRow, dCol, 0);
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, int m, int n,
                     boolean[][] visited, List<Integer> res,
                     int[] dRow, int[] dCol, int dir) {
        // base case
        if (res.size() == m * n) return;

        res.add(matrix[i][j]);
        visited[i][j] = true;

        // next step
        int next_i = i + dRow[dir], next_j = j + dCol[dir];
        if (next_i >= 0 && next_i < m && next_j >= 0 && next_j < n && !visited[next_i][next_j]) {
            dfs(matrix, next_i, next_j, m, n, visited, res, dRow, dCol, dir);
        } else {
            // change direction (right turn)
            int newDir = (dir + 1) % 4;
            int new_i = i + dRow[newDir], new_j = j + dCol[newDir];
            if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && !visited[new_i][new_j]) {
                dfs(matrix, new_i, new_j, m, n, visited, res, dRow, dCol, newDir);
            }
        }
    }
}
