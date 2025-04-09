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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null){
            return root;
        }
        TreeNode ans = solve(root,p,q);
        if(ans==p){
            return dfs(p,q)? p : null;
        }if (ans == q) {
            // Verify if p is in the subtree of q
            return dfs(q, p) ? q : null;
        }

        return ans;
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root == q){
            return root;
        } 


        TreeNode left= solve(root.left,p,q);
        TreeNode right= solve(root.right,p,q);

        if(left!=null & right!=null){
            return root;
        }

        return (left!=null) ? left: right;

    }

    public boolean dfs(TreeNode a, TreeNode b){
        //Verify if b is subtree of q;

        if(a==b){
            return true;
        }
        if(a==null){
            return false;
        }

        return dfs(a.left,b) || dfs(a.right,b);
    }
}