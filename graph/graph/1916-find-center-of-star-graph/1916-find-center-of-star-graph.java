class Solution {
    public int findCenter(int[][] edges) {
        

        // make a adj and then look for node connected n-1 number nodes, that would be center node as per definition
        // o(n);
        
        // ArrayList<ArrayList<Integer>> adj = new ArrayList();
        // int center= 0;
        // for(int i=0;i<=edges.length+1;i++){
        //     adj.add(new ArrayList<Integer>());
        // }

        // for(int[] edge: edges){
        //    int u=edge[0];
        //    int v=edge[1];

        //    adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }

        // for(int i=0;i<adj.size();i++){
        //     if(adj.get(i).size()==edges.length){
        //         center=i;
        //     }

        // }

        // HashMap

      int[] e1= edges[0];
        int[] e2= edges[1];

        return e1[0]==e2[0] || e1[0] == e2[1] ? e1[0] : e1[1];
        
       
    }
}