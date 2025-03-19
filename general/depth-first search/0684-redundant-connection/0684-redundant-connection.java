class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            boolean[] visited = new boolean[n + 1];
            if (hasCycle(adj, u, v, -1, visited)) {
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }

    private boolean hasCycle(List<List<Integer>> adj, int u, int target, int parent, boolean[] visited) {
        if (u == target) return true;
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!visited[v] && hasCycle(adj, v, target, u, visited)) {
                return true;
            }
        }

        return false;
    }
}
