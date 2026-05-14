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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        solve(root,result);
        return result;
    }

    public void solve(TreeNode root,List<List<Integer>>  res){
        if(root==null){
            return;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int level= que.size();
            List<Integer> arr= new ArrayList<>();
            for(int i=0; i<level; i++){
                TreeNode node = que.poll();
                arr.add(node.val);
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
            }
            res.add(arr);
        }

    }
}