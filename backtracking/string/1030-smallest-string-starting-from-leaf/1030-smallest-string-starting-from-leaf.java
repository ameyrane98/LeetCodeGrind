/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String res = null; // Store the smallest lexicographical string

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";

        solve(root, new StringBuilder());
        return res;
    }

    public void solve(TreeNode root, StringBuilder path) {
        if (root == null) return;

        // Prepend character to path (building from leaf to root)
        path.append((char) ('a' + root.val));

        // If it's a leaf node, compare and update result
        if (root.left == null && root.right == null) {
            String candidate = path.reverse().toString(); // Reverse to get correct order
            path.reverse(); // Reverse back to restore path for recursion

            if (res == null || candidate.compareTo(res) < 0) {
                res = candidate;
            }
        }

        // Recursive calls
        solve(root.left, path);
        solve(root.right, path);

        // Backtrack: Remove last added character
        path.deleteCharAt(path.length() - 1);
    }
}
