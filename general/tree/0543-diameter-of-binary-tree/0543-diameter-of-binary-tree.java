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

    public int result= Integer.MIN_VALUE;

    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=solve(root.left);
        int right=solve(root.right);
        
        result= Math.max(result,left+right);

        return Math.max(left,right)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }


        solve(root);

        return result;
    }
}