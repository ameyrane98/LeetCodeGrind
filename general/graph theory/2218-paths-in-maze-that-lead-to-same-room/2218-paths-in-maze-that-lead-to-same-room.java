class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        HashSet<Integer>[] adj = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new HashSet<>();
        
        for(int[] c : corridors) {
            adj[c[0]].add(c[1]);
            adj[c[1]].add(c[0]);
        }

        int count= 0;
        for(int[] rooms : corridors){
            int u = rooms[0];
            int v = rooms[1];

            for(int w : adj[u]){
                if(adj[v].contains(w)){
                    count++;
                }
            }
            

        }


        return count/3;
    }
}