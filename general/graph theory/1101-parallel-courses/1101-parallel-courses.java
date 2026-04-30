class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n+1];
        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] relation : relations){
            int u = relation[0];
            int v = relation[1];
            indegree[v]++;
            adj.get(u).add(v);
        }

        Queue<Integer> que = new LinkedList<>();
        
        for(int i =1; i<n+1; i++){
            if(indegree[i]==0){
                que.offer(i);
              
            }
        }
        int count=0;
        int coursesTaken=0;
        while(!que.isEmpty()){

        
            int level = que.size();

            for(int i =0; i<level; i++){
                int u = que.poll();
                coursesTaken++;
                for(int v : adj.get(u)){
                    indegree[v]--;
                        if(indegree[v]==0){
                            que.offer(v);
                        }
                }
            }
            
           count+=1;

        }

        return coursesTaken==n? count : -1;
    }
}