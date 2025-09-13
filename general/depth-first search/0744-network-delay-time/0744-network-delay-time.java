

import static java.util.Collections.replaceAll;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        final int INF = Integer.MAX_VALUE;
        int[] result= new int[n+1];
        Arrays.fill(result,INF);

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: times){
            int u= edge[0];
            int v= edge[1];
            int w= edge[2];

            adj.get(u).add(new int[]{v,w});
        }

        result[k]=0;
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > result[u]) continue;


            for(int[] edge: adj.get(u)){
                int v = edge[0];
                int wt= edge[1];

                if(d+wt < result[v]){
                    result[v]=d+wt ;
                    pq.offer(new int[]{d+wt,v});
                }
            }
        }

       int ans = 0;
        for (int i = 1; i <= n; i++) {
         if (result[i] == INF) return -1;
            ans = Math.max(ans, result[i]);
        }
        return ans;
    }
}