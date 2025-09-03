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
    // int max=0; // max height till now
    // public int diameterOfBinaryTree(TreeNode root) {
    //     height(root);
    //     return max;
    // }

    // public int height(TreeNode root){
    //     if(root==null){
    //         return 0;
    //     }

    //     int left = height(root.left);
    //     int right = height(root.right);
    //     max= Math.max(max, left+right);

    //     return 1+Math.max(left,right);

    // }

    public int diameterOfBinaryTree(TreeNode root) {
        TreeInfo myInfo= calculateHeight(root);
        return myInfo.dia;
    }

    public TreeInfo calculateHeight(TreeNode root){
        if(root==null){
            return new TreeInfo(0,0);
        }

        TreeInfo left= calculateHeight(root.left);
        TreeInfo right= calculateHeight(root.right);
        int  myheight= Math.max(left.ht,right.ht) + 1;

        int dim1= left.dia;
        int dim2= right.dia;
        int dim3= left.ht+right.ht;

        int dia= Math.max(Math.max(dim1,dim2),dim3);

        TreeInfo treeInfo= new TreeInfo(dia, myheight);
        
        return treeInfo;
    }
}

class TreeInfo { 
    int dia;
    int ht;
    public TreeInfo(int d, int h){
        this.dia=d;
        this.ht=h;
    }
}