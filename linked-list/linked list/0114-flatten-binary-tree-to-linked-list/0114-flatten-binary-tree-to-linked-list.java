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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }

      
        TreeNode tempRight = root.right;

        // Move left subtree to the right
        root.right = root.left;
        root.left = null;

        // Find the tail of new right and attach old right
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = tempRight;

        flatten(root.left);
        flatten(root.right);
    }
}