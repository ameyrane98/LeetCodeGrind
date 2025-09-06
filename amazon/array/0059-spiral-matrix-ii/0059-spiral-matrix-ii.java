class Solution {
    public int[][] generateMatrix(int n) {
        int[][] grid=new int[n][n];

        int top=0; int bottom = n-1; int left=0; int right=n-1;
        int val = 1;
        while(top<=bottom && left<=right){
            //left-> right
            for(int l=left; l<=right; l++){
                grid[top][l]=val++;
            }
            top++;

            //top-> bottom
            for(int t=top; t<=bottom; t++){
                grid[t][right]=val++;
            }
            right--;

            if(top<=bottom){
                //right -> left
                for(int c=right; c>=left; c--){
                    grid[bottom][c]=val++;
                }
                bottom--;
            }

            if(top<=bottom){
                //right -> left
                for(int c=bottom; c>=top; c--){
                    grid[c][left]=val++;
                }
                left++;
            }

        }

        return grid;
    }
}