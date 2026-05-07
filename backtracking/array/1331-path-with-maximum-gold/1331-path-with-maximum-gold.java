class Solution {
    int maxGold = 0;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        /** Idea
            - Path with Maximum GolD
            - grid 1= [ 0,0,0
                        5,8,7.   -> 0 is empty cell -> Never visit a cell with zero gold
                        0,9,0 ]  -> greedy can't work
                let's pick any element that is not 0
                need visited array or when you collect the gold mark that cell 0
                see if that particular path give us a the max gold
                again try a different, because there is now particular way to determine max gold form one path
                so you again put the gold in the cell and start from a different node and calculate the collected gold
                and update the maxGold
            - grid 2= [ 0,6,1] -  max gold is 7

         */


        int m= grid.length;
        int n= grid[0].length;


        for(int i=0 ; i<m ; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]!=0){
                    solve(grid,i,j,m,n,0);
                }
               
            }
        }

        return maxGold;
    }

    void solve(int[][] grid, int i , int j,int m, int n, int sum){
        if(i<0 || j<0 ||i >= m || j >=n || grid[i][j]==0){
            return ;
        }

        int gold = grid[i][j];
        sum += gold;
        maxGold = Math.max(maxGold, sum);

        grid[i][j] = 0; 

        for(int[] di :  dir){
            int xi =di[0];
            int yi= di[1];

            int x = i+xi;
            int y = j+yi;
           solve(grid,  x, y, m, n, sum);
        }
        grid[i][j] = gold;                  

    }
}