class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int cols = board[0].length;

        if (row == 0 || cols == 0) return; // Edge case

        // Step 1: Use DFS to mark border-connected 'O' cells as 'T'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == cols - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // Step 2: Flip remaining 'O' → 'X' and 'T' → 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // Surrounded 'O' -> 'X'
                if (board[i][j] == 'T') board[i][j] = 'O'; // Restore border 'O's
            }
        }
    }

    // DFS Helper Function
    private void dfs(char[][] board, int i, int j) {
        int row = board.length;
        int cols = board[0].length;

        // Base case: Out of bounds or already visited or 'X'
        if (i < 0 || j < 0 || i >= row || j >= cols || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Mark border-connected 'O' as safe

        // DFS in all 4 directions
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
