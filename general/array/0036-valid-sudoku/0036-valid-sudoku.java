  class Solution{
  
  public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] subGrids = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                if (current != '.') {
                    int digit = current - '1';
                    int subGridIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][digit] || cols[j][digit] || subGrids[subGridIndex][digit]) {
                        return false;
                    }

                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    subGrids[subGridIndex][digit] = true;
                }
            }
        }

        return true; 
    }
  }