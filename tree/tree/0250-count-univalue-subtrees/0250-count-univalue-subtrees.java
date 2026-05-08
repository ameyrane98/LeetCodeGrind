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
    int count = 0;  // instance field
    
    public int countUnivalSubtrees(TreeNode root) {
        isUniVal(root);
        return count;
    }
    

    boolean isUniVal(TreeNode root){
        if(root==null){
            return true;
        }

        boolean leftIsUniValue = isUniVal(root.left);
        boolean rightIsUniValue = isUniVal(root.right);
        // if none are uniValue return false
        if (!leftIsUniValue || !rightIsUniValue) return false;
        // if my children value dont match mine return false;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        count++;
        return true;
    }
}