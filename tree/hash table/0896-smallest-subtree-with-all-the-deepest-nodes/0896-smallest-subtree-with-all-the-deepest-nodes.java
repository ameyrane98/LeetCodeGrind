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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private Result dfs(TreeNode node) {
        
    // base case?
        if(node==null){
            return new Result(null,-1);
        }
    // recurse left, recurse right
        Result left= dfs(node.left);
        Result right =dfs(node.right);


    // 3 cases based on depth comparison

        if(left.depth==right.depth){
            return new Result(node,left.depth+1);
        }

        if(left.depth>right.depth){
            return new Result(left.node,left.depth+1);
        }

        return new Result(right.node,right.depth+1);

    }  

    class Result {
        TreeNode node;
        int depth;
        Result(TreeNode n, int d) { node = n; depth = d; }
    }



}