class Solution {
    /**without using a visited array */
    // int[][] directions= new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    // public boolean exist(char[][] board, String word) {
    //     int m= board.length;
    //     int n= board[0].length;

    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(board[i][j]==word.charAt(0) && find(board, word,m,n, 0, i, j)){
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;


    // }

    // boolean find(char[][] board, String word,int m, int n,int wIdx, int i, int j){
    //     if(wIdx==word.length()){
    //         return true;
    //     }

    //     if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='$'){
    //         return false;
    //     }

    //     if(board[i][j]!=word.charAt(wIdx)){
    //         return false;
    //     }

    //     char temp=board[i][j];
    //     board[i][j]='$';
    //     for(int[] dir: directions){
    //        int new_i=i+dir[0];
    //        int new_j=j+dir[1];
    //        if(find(board,word,m,n,wIdx+1,new_i,new_j)){
    //             return true;
    //        }
    //     }
    //     board[i][j]=temp;
    //     return false;
    // }


    /**Code using a visited array */

    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(checNextWor(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean checNextWor(char[][] board,String word,int matchIdx,int row,int col,boolean[][] visited){
        if (matchIdx == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            visited[row][col] || board[row][col] != word.charAt(matchIdx)) {
            return false;
        }

        visited[row][col]=true;
        boolean found=checNextWor(board,word,matchIdx+1,row+1,col,visited)||
                         checNextWor(board,word,matchIdx+1,row-1,col,visited) ||
                         checNextWor(board,word,matchIdx+1,row,col+1,visited)||
                             checNextWor(board,word,matchIdx+1,row,col-1,visited);
                 
         visited[row][col]=false;

        return found;
    }
}