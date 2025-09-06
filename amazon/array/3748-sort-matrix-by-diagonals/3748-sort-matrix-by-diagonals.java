class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n= grid.length;
        

    
        for(int j=1; j<n;j++){
            ArrayList<Integer> arr = new ArrayList<>();
            extract(grid,0,j,arr);
            arr.sort((a,b)->a-b);
            edit(grid,0,j,0,arr);
        }

        for(int i=0; i<n;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            extract(grid,i,0,arr);
            arr.sort((a,b)->b-a);
            edit(grid,i,0,0,arr);
        }

        return grid;
    }

    public void extract(int[][]grid,int i, int j,ArrayList<Integer> arr ){
        int n= grid.length;
        if(i>=n || j>=n){
            return;
        }

        arr.add(grid[i][j]);
        extract(grid,i+1,j+1,arr);
    }

    public void edit(int[][]grid,int i,int j,int idx,ArrayList<Integer> arr){
        int n= grid.length;
        if(i>=n || j>=n){
            return;
        }

        grid[i][j]=arr.get(idx);
        edit(grid,i+1,j+1,idx+1,arr);
    }
}