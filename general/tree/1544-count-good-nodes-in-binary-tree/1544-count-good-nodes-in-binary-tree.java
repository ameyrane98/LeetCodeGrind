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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        solve(root,root.val);

        return count;
    }

    public void solve(TreeNode root,int maxSoFar){
        if(root==null){
            return;
        }

        if(root.val>=maxSoFar){
        
            count++;
            maxSoFar=root.val;
        }

        solve(root.left,maxSoFar);
        solve(root.right,maxSoFar);
    }
}