class Solution {
    List<List<String>> result= new ArrayList();
    void solve(String[][] board,int row, int n){
        if(n == row){
            result.add(convertBoardToList(board));
            return;
        }

        for(int col=0; col<n; col++){
            if(isSafe(board,row,col,n)){

                board[row][col]= "Q";

                solve(board,row+1,n);

                board[row][col]=".";

            }
        }

    }

    boolean isSafe(String[][] board,int row,int col,int n){
        // check columns
        for(int i=0; i<row; i++){
            if(board[i][col].equals("Q")){
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        
        // Check upper-right diagonal
        for(int i=row-1, j=col+1; i >=0 && j<n; i--,j++){
            if(board[i][j].equals("Q")){
                return false;
            }
        }

        return true;

    }
    public List<String> convertBoardToList(String[][] board) {
        List<String> boardList = new ArrayList<>();
        for (String[] row : board) { // Iterate through each row
            StringBuilder rowString = new StringBuilder();
            for (String cell : row) { // Concatenate all cells in the row
                rowString.append(cell);
            }
            boardList.add(rowString.toString()); // Add the row as a string to the list
        }
        return boardList;
    }
    public static void printBoard(String[][] board) {
        for (String[] row : board) { // Iterate through each row
            for (String cell : row) { // Iterate through each cell in the row
                System.out.print(cell.toString() + " "); // Print cell with a space
            }
            System.out.println(); // New line after each row
        }
    }


    public List<List<String>> solveNQueens(int n) {
        String[][] board= new String[n][n];

        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                board[i][j]=".";
            }
        }

        solve(board,0, n);
        return result;
    }   
}