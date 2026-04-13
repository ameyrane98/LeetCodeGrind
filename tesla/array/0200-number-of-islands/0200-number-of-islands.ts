function numIslands(grid: string[][]): number {
    let m: number = grid.length
    let n: number = grid[0].length
    let numIslands: number = 0
    for(let i=0; i<m; i++){
        for(let j=0; j<n; j++){
            if(grid[i][j]=="1"){
                solve(i,j,m,n,grid);
                numIslands++;
            }
        }
    }



    return numIslands;
};



function solve(i: number,j: number,m: number, n:number ,grid: string[][]){
    if(i<0 || j<0 || i >=m || j >=n || grid[i][j]=="0"){
        return;
    }

    grid[i][j]="0"

    solve(i+1,j,m,n,grid);
    solve(i,j+1,m,n,grid);
    solve(i-1,j,m,n,grid);
    solve(i,j-1,m,n,grid);
}
