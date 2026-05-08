/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      boolean foundP = false, foundQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = dfs(root,p,q);

        return (foundP && foundQ)? lca: null;
    }

    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

        TreeNode left =dfs(root.left,p,q);
        TreeNode right =dfs(root.right,p,q);

        if(root==p){
            foundP=true;
            return root;
        }

        if(root==q){
            foundQ=true;
            return root;
        }


        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}