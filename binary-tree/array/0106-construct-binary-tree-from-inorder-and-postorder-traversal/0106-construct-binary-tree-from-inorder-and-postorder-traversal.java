

import static java.lang.Integer.max;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {


        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        int[] postIndex= {postorder.length-1};
        return build(0, inorder.length-1, postorder, postIndex, map);
    }

    private TreeNode build(int inStart, int inEnd, int[] postorder, int[] postIndex,Map<Integer, Integer> map){
        // i need to impleme this now

        if(inStart>inEnd){
            return null;
        }

        TreeNode node= new TreeNode(postorder[postIndex[0]]);

        int index= map.get(node.val);
        postIndex[0]--;

        // because we are moving backward in postorder
        node.right= build(index+1,inEnd,postorder,postIndex,map);
        node.left= build(inStart,index-1,postorder,postIndex,map);
      

        return node;

    }
}