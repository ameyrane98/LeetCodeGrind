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
    int sum =0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return solve(root,0);
    }

    int solve(TreeNode root, int number){
        if(root==null){
            return 0;
        }
         
        number = number * 10+ root.val;
        
        if(root.left==null && root.right==null){
            sum+=number;
        }


       
        solve(root.left,number);
        solve(root.right,number);

        return sum;
    }
}