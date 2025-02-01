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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        right(root,0,list);
        return list;
    }
    public void right(TreeNode root,int lvl,List<Integer> list){
        if(root==null) return;
        if(lvl==list.size()) list.add(root.val);
        right(root.right,lvl+1,list);
        right(root.left,lvl+1,list);
        return;
    }
}