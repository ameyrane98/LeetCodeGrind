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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        if(solve(root.left)-solve(root.right)>1){
            return false;
        }

        return true;
    }

    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        return solve(root.left)+solve(root.left)+1;
    }
}