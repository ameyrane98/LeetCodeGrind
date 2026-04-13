class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i =0; i<n ; i++){
            for(int j=i; j<n ; j++){
                swap(i,j,matrix,n);
            }
        }

        for(int i =0; i<n ; i++){
            reverse(matrix[i],n);
        }

    }

    void swap(int i, int j, int[][] grid,int n){

        int temp =grid[i][j];
        grid[i][j]=grid[j][i];
        grid[j][i]=temp;
    }

    // We pass the specific row (grid[i]) and its length (n)
void reverse(int[] row, int n) {
    int left = 0;
    int right = n - 1;
    
    while (left < right) {
        // Swap elements at the left and right pointers
        swapele(left, right, row);
        
        // Move the pointers toward the center
        left++;
        right--;
    }
}

    void swapele(int i, int j, int[] list){
        
        int temp = list[i];
        list[i]= list[j];
        list[j]= temp;
    }
}