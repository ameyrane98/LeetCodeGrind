class Solution {
    int res;
    public int totalNQueens(int n) {
        String[][] board = new String[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j]=".";
            }
        }

        res=0;
        solve(board,0,n);
        return res; 
    }

      public void solve(String[][] board, int row, int n){
        if(row==n){
            res++;
            return;
        }
        

        for(int col=0; col< n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col]="Q";
                solve(board,row+1,n);
                board[row][col]=".";
            }
        }

    }

    public boolean isSafe(String[][] board, int row, int col, int n){
        for(int i=0; i<row;i++){
            if(board[i][col].equals("Q")){
                return false;
            }
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j].equals("Q")){
                return false;
            }
        }

        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(board[i][j].equals("Q")){
                return false;
            }
        }

        return true;
    }
}