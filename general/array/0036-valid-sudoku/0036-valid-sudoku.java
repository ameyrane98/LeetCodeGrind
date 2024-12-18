class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashSets for rows, columns, and 3x3 grids
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) { // Iterating through rows
            for (int j = 0; j < 9; j++) { // Iterating through columns
                char current = board[i][j];
                
                if (current != '.') { // Skip empty cells
                    // Create unique keys for rows, columns, and sub-grids
                    String rowKey = "row" + i + current;
                    String colKey = "col" + j + current;
                    String gridKey = "grid" + (i / 3) + (j / 3) + current;
                    
                    // If any key already exists, the board is invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(gridKey)) {
                        return false;
                    }
                }
            }
        }

        return true; // If no duplicates, the board is valid
    }
}
