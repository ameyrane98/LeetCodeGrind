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
    List<Integer> sortedArray = new LinkedList<>();
    public TreeNode balanceBST(TreeNode root) {
       inorder(root);
       return buildBst(sortedArray,0,sortedArray.size()-1);
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);

        sortedArray.add(root.val);


        inorder(root.right);
    }

    TreeNode buildBst(List<Integer> sortedArray,int low, int high){
        if(low>high) return null;
        int mid = low+(high-low)/2;
        TreeNode root = new TreeNode(sortedArray.get(mid));

        root.left= buildBst(sortedArray,low,mid-1);
        root.right= buildBst(sortedArray,mid+1,high);

        return root;
    }

}