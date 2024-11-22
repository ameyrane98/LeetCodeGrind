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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }

        if(root.left!=null || root.right !=null){
            TreeNode temp =root.right;// store the original right subtreee
            root.right=root.left;// do the switch 
            root.left=null;


            TreeNode curr= root; // transvere to rightest subtree 

            while(curr.right!=null){
                curr=curr.right;
            }
            curr.right=temp;// attace the orginal right subtree
        }


        flatten(root.left);
        flatten(root.right);
    }
}