class Solution {
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
        checNextWor(board,word,matchIdx+1,row-1,col,visited) ||checNextWor(board,word,matchIdx+1,row,col+1,visited)||
        checNextWor(board,word,matchIdx+1,row,col-1,visited);
        visited[row][col]=false;

        return found;
    }
}