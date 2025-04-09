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
    /** Brute force  O(n) and O(n)*/
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     List<TreeNode> pathP = new ArrayList<>();
    //     List<TreeNode> pathQ = new ArrayList<>();

    //     findPath(root, p, pathP);
    //     findPath(root, q, pathQ);

    //     // Compare paths to get the last common node
    //     int i = 0;
    //     while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
    //         i++;
    //     }

    //     return pathP.get(i - 1);
    // }

    // // Helper to find path from root to target node
    // private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
    //     if (root == null) return false;

    //     path.add(root);

    //     if (root == target) return true;

    //     if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
    //         return true;
    //     }

    //     path.remove(path.size() - 1); // backtrack
    //     return false;
    // }

    /**Optimal */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        return solve(root,p,q);
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root == p || root ==q){
            return root;
        }

        TreeNode left= solve(root.left,p,q);
        TreeNode right= solve(root.right,p,q);
        
        if(left!=null && right!=null){
            return root;
        }

        return left!=null ? left: right;
    } 
}