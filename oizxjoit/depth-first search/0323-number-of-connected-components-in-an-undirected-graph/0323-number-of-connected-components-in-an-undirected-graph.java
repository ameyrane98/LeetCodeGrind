class Solution {
    
    public int countComponents(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int counter=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(adj,i,visited);
                counter++;
            }
        }
       

        return counter;
    }

    void bfs(ArrayList<ArrayList<Integer>> adj, int i,boolean[] visited){
        Queue<Integer> que = new ArrayDeque<>();

        que.add(i);
        visited[i]= true;

        while(!que.isEmpty()){
            int u = que.poll();
            for(int v : adj.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    que.offer(v);
                }
            }
        }
    }
}