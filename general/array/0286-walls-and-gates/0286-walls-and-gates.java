class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    que.offer(new int[]{i,j});
                }

            }
        }
        int[][] dir = new int[][] {{1,0},{0,1},{0,-1},{-1,0}};

       
        int curr_dis = 1 ;
        while(!que.isEmpty()){
            int[] pos = que.poll();
            int x1 = pos[0];
            int y1 = pos[1];
            for(int[] di : dir){
                int x = pos[0] + di[0];
                int y = pos[1] + di[1];
                if(x<0 || y <0 || x >=m || y>=n ){
                    continue;
                }

                if(rooms[x][y] == 2147483647){
                    rooms[x][y]=rooms[x1][y1]+1;
                    que.add(new int[]{x,y});
                }

            }

        }

       
    }
}