class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize parent and rank arrays
        int[] parent = new int[nums.length];
        int[] rank = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // A map to store the index of each number for fast lookup
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        // Helper functions for union-find
      

        // Union numbers that are consecutive
        for (int num : nums) {
            if (numToIndex.containsKey(num - 1)) {
                union(numToIndex.get(num - 1), numToIndex.get(num), parent, rank);
            }
            if (numToIndex.containsKey(num + 1)) {
                union(numToIndex.get(num + 1), numToIndex.get(num), parent, rank);
            }
        }

        // Find the length of the largest connected component
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int root = find(i, parent);
            sizeMap.put(root, sizeMap.getOrDefault(root, 0) + 1);
            maxLength = Math.max(maxLength, sizeMap.get(root));
        }

        return maxLength;
    }

      int find(int x, int[] parent) {
            if (parent[x] != x) {
                parent[x] = find(parent[x], parent); // Path compression
            }
            return parent[x];
        }

        void union(int a, int b, int[] parent, int[] rank) {
            int rootA = find(a, parent);
            int rootB = find(b, parent);

            if (rootA != rootB) {
                // Union by rank
                if (rank[rootA] > rank[rootB]) {
                    parent[rootB] = rootA;
                } else if (rank[rootA] < rank[rootB]) {
                    parent[rootA] = rootB;
                } else {
                    parent[rootA] = rootB;
                    rank[rootB]++;
                }
            }
        }
}
