class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return solve(arr, start, visited);
    }

    public boolean solve(int[] arr, int i, boolean[] visited) {
        // Out of bounds or already visited
        if (i < 0 || i >= arr.length || visited[i]) {
            return false;
        }

        // Found a path to 0
        if (arr[i] == 0) {
            return true;
        }

        // Mark as visited
        visited[i] = true;

        // Try both possible jumps
        return solve(arr, i + arr[i], visited) || solve(arr, i - arr[i], visited);
    }
}
