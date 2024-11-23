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
    List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root!=null){
            return dfs(root,res,"");
        }

        return res;
    }

    List<String> dfs(TreeNode root, List<String> res, String sb){

        if(root.left==null && root.right==null){

            res.add(sb+root.val);
        }

        if(root.left!=null){
            dfs(root.left,res,sb+root.val+"->");
        }

        
        if(root.right!=null){
            dfs(root.right,res,sb+root.val+"->");
        }

        return res;
    }
}