class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        
        solve(graph,0,n, new LinkedList<>());
        

        return res;
    }

    void solve(int[][] graph, int u, int n,List<Integer> ans ){
        if(u==n-1){
            res.add(new LinkedList(ans));
            return;
        }
        if(u==0){
            ans.add(0);
        }

        for(int v : graph[u]){
            ans.add(v);
            solve(graph,v,n,ans);
            ans.remove(ans.size()-1);
        }

        
    }

}