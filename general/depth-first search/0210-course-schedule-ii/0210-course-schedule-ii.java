class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited= new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];   
        Stack<Integer> stck= new Stack<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites){
            int u= prereq[1];
            int v= prereq[0];

            adj.get(u).add(v);
        }

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if (hasCycle(adj, i, visited, inRecursion, stck)) {
                    return new int[0];  // cycle -> no topo order
                }
             
            }
        }
    

        
        int[] order = new int[stck.size()];
        int k = 0;
        while (!stck.isEmpty()) order[k++] = stck.pop();
        return order;
    }


    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion ,Stack<Integer> stck){
        visited[u]=true;
         inRecursion[u]=true;
        for(int v: adj.get(u)){
            if(inRecursion[v]){
                return true;
            }
            if(!visited[v]){
                if(hasCycle(adj, v, visited,inRecursion, stck)){
                    return true;
                }
            }
        }

        inRecursion[u]=false;
        
        stck.push(u);
        return false;
    }
}