class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        // Build graph: A→B with weight w, B→A with weight 1/w
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double w = values[i];
            graph.computeIfAbsent(A, k -> new HashMap<>()).put(B, w);
            graph.computeIfAbsent(B, k -> new HashMap<>()).put(A, 1.0 / w);
        }

        // Answer each query with DFS
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            result[i] = dfs(graph, u, v, 1.0, new HashSet<>());
        }

        return result;
    }

    double dfs(HashMap<String, HashMap<String, Double>> graph,
               String curr,
               String target,
               double product,
               Set<String> visited) {

        // Node doesn't exist in graph at all
        if (!graph.containsKey(curr) || !graph.containsKey(target)) return -1.0;

        // Already visited — avoid cycles
        if (visited.contains(curr)) return -1.0;

        // Found target — return accumulated product
        if (curr.equals(target)) return product;

        visited.add(curr);

        // Try every neighbor
        for (Map.Entry<String, Double> entry : graph.get(curr).entrySet()) {
            String neighbor = entry.getKey();
            double weight   = entry.getValue();

            double res = dfs(graph, neighbor, target, product * weight, visited);

            // Only return if a valid path was found — otherwise keep trying
            if (res != -1.0) return res;
        }

        return -1.0; // No path found
    }
}