class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited= new boolean[numCourses];
        boolean[] inRecursion= new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites){
            int u= prereq[1];
            int v= prereq[0];

            adj.get(u).add(v);
        }

        for(int i=0; i<numCourses; i++){
            if(!visited[i] && hasCycle(adj,i,visited,inRecursion)){
                return false;
            }
        }

    return true;
    }

    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited,boolean[] inRecursion ){
        visited[u]=true;
        inRecursion[u]=true;

        for(int v:adj.get(u)){
            if(!visited[v]){
                if(hasCycle(adj, v, visited, inRecursion)){
                    return true;
                }
            }else if(inRecursion[v]){
                    return true;
            }
        }

        inRecursion[u]=false;

        return false;
    }
}