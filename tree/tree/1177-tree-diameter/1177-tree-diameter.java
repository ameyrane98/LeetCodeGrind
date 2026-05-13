class Solution {
    int distance =0;
    public int treeDiameter(int[][] edges) {
        /** Two pass BFS
        
         */

        List<List<Integer>> adj= new LinkedList<>();
        int n = edges.length+1;
        for(int i=0; i<n; i++){
            adj.add(new LinkedList<>());
        }

        for(int[] edge: edges){
            int u=edge[0];int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }  

        
        int node=bfs(adj,0);
        int diameter=bfs(adj,node);
      

        return distance;
    }

    int bfs(List<List<Integer>> adj, int start){
        Queue<Integer> que= new LinkedList<>();
        boolean[]visited = new boolean[adj.size()];
        que.offer(start);
        visited[start]=true;
        int dist =0;
        int last= start;
        while(!que.isEmpty()){
            int level = que.size();

            for(int i=0; i<level; i++){
                int curr = que.poll();
                last=curr;

                for(int v : adj.get(curr)){
                    if(!visited[v]){
                        que.offer(v);
                        visited[v]=true;
                    }
                }


            }

            if (!que.isEmpty()) dist++;  
            
        }

        this.distance =dist;
        return last;
    }
}