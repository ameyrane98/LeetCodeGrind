class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hset= new HashSet();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char current= board[i][j];

                if(current!='.'){
                    String rowKey= "row"+current+i;
                    String colKey= "column"+j+ current;
                    String gridKey= i/3 + "," + j/3+current;

                    if(!hset.add(rowKey) || !hset.add(colKey) || !hset.add(gridKey)){
                        return false;
                    }

                }
                

            }
        }

        return true;
    }
}