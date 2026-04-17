class Solution {
    int counter=1;
    public boolean validTree(int n, int[][] edges) {
        /** valid tree we need to have n node have n-1 edges
         */
        if(edges.length!= n-1){
            return false;
        }

        // now we just have to check if the edges are connected, so that it's valid tree
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       /**  adj 
            [
                0->1
                1->2,3,4
            ]
        */

        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        
       
        dfs(adj,0,visited);
        
        System.out.println(counter);
            
        return counter == visited.length;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int u,boolean[] visited){
        visited[u]=true;
        for(int v: adj.get(u)){
            if(!visited[v]){
                dfs(adj,v,visited);
                counter++;
            }
        }
     
    }

}