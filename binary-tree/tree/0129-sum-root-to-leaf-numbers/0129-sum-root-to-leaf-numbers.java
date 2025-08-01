class Solution {
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    private int solve(TreeNode root, int currentSum) {
        if (root == null) return 0;

        currentSum = currentSum * 10 + root.val;

        // If it's a leaf node, return the path sum
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        // Sum from left and right subtrees
        return solve(root.left, currentSum) + solve(root.right, currentSum);
    }
}
