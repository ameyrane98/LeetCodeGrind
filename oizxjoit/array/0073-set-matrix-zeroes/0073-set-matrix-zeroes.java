class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstColHasZero = false;

        // Step 1 - check col 0 separately
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) firstColHasZero = true;
        }

        // Step 2 - use row 0 and col 0 as flags
        // start j from 1 to protect [0][0]
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;  // mark row
                    matrix[0][j] = 0;  // mark col
                }
            }
        }

        // Step 3 - zero out cells using flags
        // start from bottom right, i from m-1, j from 1
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4 - handle col 0 separately at the end
        if(firstColHasZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}