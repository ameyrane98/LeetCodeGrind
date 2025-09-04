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
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(memo.containsKey(root)){
            return memo.get(root);
        }

        int rob= root.val;
        if (root.left != null) {
            rob += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            rob += rob(root.right.left) + rob(root.right.right);
        }
        int skip= rob(root.left) +rob(root.right);
        
        int ans = Math.max(rob, skip);
        memo.put(root, ans);
        return ans;

    }
}