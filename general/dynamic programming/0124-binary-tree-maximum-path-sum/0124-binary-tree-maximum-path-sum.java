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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        computeMaxPath(root);
        return maxSum;
    }

    public int computeMaxPath(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=Math.max(0,computeMaxPath(root.left)); //ignore negative
        int right= Math.max(0,computeMaxPath(root.right)); 

        maxSum= Math.max(maxSum,left+right+root.val);

        return Math.max(left,right)+root.val; // check if left is bigger or right and nodes to it
    }
}