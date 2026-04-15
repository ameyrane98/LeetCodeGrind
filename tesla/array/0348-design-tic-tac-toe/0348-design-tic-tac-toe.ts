class TicTacToe {
    grid: number[][];
    n: number;
    constructor(n: number) {
        this.n= n;
        this.grid = Array.from({length: n}, ()=> Array(n).fill(0));
    }

    move(row: number, col: number, player: number): number {
        if(this.grid[row][col]!=0){
            return -1;
        }

        this.grid[row][col]=player;

        let rowWin = true;
        for(let j=0; j<this.n; j++){
            if(this.grid[row][j]!=player){
                rowWin=false;
                break;
            }
        }
        if (rowWin) return player;


        let colWin = true;
        for(let j=0; j<this.n; j++){
            if(this.grid[j][col]!=player){
                colWin=false;
                break;
            }
        }
        if (colWin) return player;

        if(row==col){
            let diaWin = true;
            for(let i=0; i<this.n; i++){
              
                if(this.grid[i][i]!=player){
                    diaWin=false;
                    break;
                }
                
            }
            if (diaWin) return player;
        }

          


// anti-diagonal
        if (row + col === this.n - 1) {
            let antiWin = true;
            for (let i = 0; i < this.n; i++) {
                if (this.grid[i][this.n - 1 - i] !== player) {
                    antiWin = false;
                    break;
                }
            }
            if (antiWin) return player;
        }


        return 0;
    }

 
}
