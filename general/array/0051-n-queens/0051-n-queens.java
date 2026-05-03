class Solution {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
           
        for(int row= 0; row<n; row++){   
            for(int col= 0; col<n; col++){ 
                board[row][col]='.';
            }
        }
        int col=0;

     
       
       
        solve(board,0,n);
            
        return res;
    }

    void solve(char[][]board, int row,int n){

        if(row==n){
            List<String> ans = new ArrayList<>();
            for(char[] cL : board){
                StringBuilder sb= new StringBuilder();
                for(char c: cL ){
                    sb.append(c);
                }
                ans.add(sb.toString());
            }
            res.add(ans);
            return;
        }
        

        for(int col=0;col<n;col++){
            if(canbePlaced(board, row, col, n)){
                board[row][col]='Q';
                solve(board, row+1, n);
                board[row][col]='.';
            }
        
        }
         
    }

    boolean canbePlaced(char[][]board, int i, int j, int n){
        if(i>=n || j>=n|| i<0|| j<0 ){
            return false;
        }

        for(int row =0; row<i; row++){ //row from top
            if(board[row][j]=='Q'){
                return false;
            }
        }

        for(int col =0; col<i; col++){ //row from top
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int row =i-1, col =j-1; row>=0 && col>=0; row--,col--){  
                if(board[row][col]=='Q'){
                    return false;
                }
        }

        for(int row =i-1, col =j+1; row>=0 && col<n; row--,col++){  
                if(board[row][col]=='Q'){
                    return false;
                }
        }

        return true;
    }
}