class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        
        int[][] dir = {{-1,-1},{-1,0},{-1,1},
                        {0,-1},{0,1},
                        {1,-1},{1,0},{1,1},
                        };

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                int live=0;
                for(int k=0;k<8; k++){
                    int r= i+dir[k][0];  
                    int c= j+dir[k][1];

                    if(r>=0 && r<m && c>=00 && c<n && board[r][c]==1){
                        live++;
                    }
                }
                    if(board[i][j]==1){
                        result[i][j]= (live==2 || live ==3) ? 1 :0;
                    }else {
                        result[i][j] = (live == 3) ? 1 : 0;
                    }


               
            }
        }


        for (int i = 0; i < m; i++) {
            System.arraycopy(result[i], 0, board[i], 0, n);
        }
    }

  
}