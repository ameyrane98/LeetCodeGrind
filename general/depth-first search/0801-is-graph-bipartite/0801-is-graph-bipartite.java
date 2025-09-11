class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
        int n = graph.length;
        int[] color = new int[n];
         Arrays.fill(color, -1);
        for(int i=0; i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n ;i++){
            for(int u: graph[i]){
                adj.get(i).add(u);
            }
        }

        for(int i=0; i<n ;i++){
            if(color[i]==-1){
                if(dfs(adj,i,color,1)){
                    return false;
                };
            }
        }

        return true;
    }

    public boolean dfs( ArrayList<ArrayList<Integer>> adj,int u,int[] color, int currColor){

        color[u]=currColor;

        for(int v : adj.get(u)){
            if(color[v]==currColor){
                return true;
            }
            if(color[v]==-1){
                if(dfs(adj,v,color,1-currColor)){
                    return true;
                }
            }
        }

        return false;
    }
}