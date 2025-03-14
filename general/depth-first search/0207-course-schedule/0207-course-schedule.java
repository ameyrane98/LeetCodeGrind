class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited= new boolean[numCourses];
        boolean[] inRecursion= new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());  // Initialize empty list for each course
        }

        // Step 2: Fill adjacency list based on prerequisites
        for (int[] courses : prerequisites) {
            adj.get(courses[1]).add(courses[0]); // Course 'courses[0]' depends on 'courses[1]'
        }

    
       for(int i=0; i< numCourses; i++){
            if(!visited[i] && dfs(adj,i,visited,inRecursion)){
                return false;
            }
       }

        return true;
    }

    boolean dfs(List<List<Integer>> adj,int u,boolean[] visited,boolean[] inRecursion){

        visited[u]=true;
        inRecursion[u] =true;

        for(int v : adj.get(u)){
            if(!visited[v] && dfs(adj,v,visited,inRecursion)){
                return true;
            }else if(inRecursion[v]){
                return true;
            }
        }

        inRecursion[u]=false;
        return false;
    }
}