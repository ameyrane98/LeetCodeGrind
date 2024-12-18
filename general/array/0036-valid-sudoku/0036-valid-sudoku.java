import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create HashMaps to track seen numbers in rows, columns, and grids
        HashMap<Integer, Set<Character>> rowMap = new HashMap<>();
        HashMap<Integer, Set<Character>> colMap = new HashMap<>();
        HashMap<String, Set<Character>> gridMap = new HashMap<>();
        
        // Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                if (current == '.') continue; // Skip empty cells
                
                // Create keys for row, column, and grid
                String gridKey = (i / 3) + "," + (j / 3);
                
                // Initialize sets in the maps if not already present
                rowMap.putIfAbsent(i, new HashSet<>());
                colMap.putIfAbsent(j, new HashSet<>());
                gridMap.putIfAbsent(gridKey, new HashSet<>());

                // Check for duplicates
                if (!rowMap.get(i).add(current)) return false; // Duplicate in row
                if (!colMap.get(j).add(current)) return false; // Duplicate in column
                if (!gridMap.get(gridKey).add(current)) return false; // Duplicate in grid
            }
        }
        
        return true; // No duplicates found
    }
}
