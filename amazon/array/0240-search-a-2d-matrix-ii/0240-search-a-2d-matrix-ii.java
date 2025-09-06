class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n= matrix[0].length;
        for(int i=0; i<m ;i++){

            if(target<matrix[i][0] || target> matrix[i][n-1]){
                continue;
            }

            if(bs(matrix[i],0,matrix[i].length,target)){
                    return true;
            }
              
        }
        return false;
    }

    public boolean bs(int[] arr,int l, int r, int t){

        while(l<r){
            int mid= (r+l)/2;

            if(arr[mid]==t){
                return true;
            }

            if(t<arr[mid]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}