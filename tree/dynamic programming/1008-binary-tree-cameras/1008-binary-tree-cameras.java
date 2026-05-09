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
   int count = 0;

    public int minCameraCover(TreeNode root) {
        int rootState = dfs(root);
        if (rootState == 0) count++;
        return count;
    }

    int dfs(TreeNode root) {
        if (root == null) return 2;
        int L = dfs(root.left);
        int R = dfs(root.right);
        if (L == 0 || R == 0) { count++; return 1; }   // child needs help
        if (L == 1 || R == 1) return 2;                 // child has camera, I'm covered
        return 0;                                       // both covered, I'm exposed
    }
}