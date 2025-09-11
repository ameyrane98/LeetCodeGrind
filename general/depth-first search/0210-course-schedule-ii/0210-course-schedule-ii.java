import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];   // NEW
        Stack<Integer> stck = new Stack<>();

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            int u = p[1], v = p[0];
            adj.get(u).add(v);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
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

    // returns true if a cycle is found
    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int u,
                             boolean[] visited, boolean[] inRecursion, Stack<Integer> stck) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {
            if (inRecursion[v]) return true;                     // back-edge -> cycle
            if (!visited[v] && hasCycle(adj, v, visited, inRecursion, stck)) return true;
        }

        inRecursion[u] = false;  // backtrack
        stck.push(u);            // post-order push for topo
        return false;
    }
}
