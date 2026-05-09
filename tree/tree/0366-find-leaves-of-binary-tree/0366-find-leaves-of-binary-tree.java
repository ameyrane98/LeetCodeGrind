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
    List<List<Integer>> res= new LinkedList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null){
            return res;
        }

        height(root);
        return res;
    }

    int height(TreeNode root){
        if(root==null){
            return -1;
        }

        int h = 1 + Math.max(height(root.left),height(root.right));

        if(res.size()==h){
            res.add(new ArrayList<>());
        }

        res.get(h).add(root.val);
        return h;
    }
}