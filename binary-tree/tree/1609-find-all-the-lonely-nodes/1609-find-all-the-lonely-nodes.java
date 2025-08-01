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
    ArrayList<Integer> result= new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        if(root==null){
            return result;
        }

        if(root.left!=null && root.right==null){
            result.add(root.left.val);
        }

        if(root.left==null && root.right!=null){
            result.add(root.right.val);
        }

        getLonelyNodes(root.left);
        getLonelyNodes(root.right);

        return result;

    }
}