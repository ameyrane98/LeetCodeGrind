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
    int i;
    HashMap<Integer, Integer> Hmap= new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        for(int ix=0; ix< inorder.length; ix++){
            Hmap.put(inorder[ix],ix);
        }

        return helper(preorder,0,inorder.length-1);
    }

    TreeNode helper(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }

        int nodeVal=preorder[ i++];
        TreeNode node = new TreeNode(nodeVal);
        int idx= Hmap.get(nodeVal);
       
        node.left= helper(preorder,start,idx-1);
        node.right= helper(preorder,idx+1,end);
        
        return node;
    }
}