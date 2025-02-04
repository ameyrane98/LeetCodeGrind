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
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }

        bfs(root);


        return res;
    }

    public void bfs(TreeNode root){
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while(!que.isEmpty()){
            int que_size = que.size();
            List<Integer> data=new ArrayList();
            for(int i=0; i<que_size ; i++){
                TreeNode node = que.poll();
                data.add(node.val);

                if(node.left!=null){
                    que.offer(node.left);
                }

                if(node.right!=null){
                    que.offer(node.right);
                }
            }

            res.add(data.get(data.size()-1));
        }
    }
}