class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        if (m == 0) return new int[0];
        int n = mat[0].length;
        int[] res= new int[m*n];
        int i =0; int j =0; int idx=0;
        int dir=1;

        while(idx<m*n){
            res[idx++]= mat[i][j];

            if(dir==1){
                if(j==n-1){
                    // we have reached the top right corner
                    i++;
                    dir= -1;
                }else if(i==0){
                    // we have reachd the top border
                    j++; 
                    dir= -1;
                }else{
                    i--;
                    j++;
                }
            }else{
                if(i == m-1){
                    j++;
                    dir=1;
                }else if(j==0){
                    i++;
                    dir=1;
                }else{
                    i++;
                    j--;
                }
            }
        }

        return res;

    }
}