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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
           return res;
        }

        bfs(root);

        return res;
    }

    public void bfs(TreeNode root){
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int levelSize= que.size();
            List<Integer> levelNodes= new ArrayList<>();


            for(int i=0; i<levelSize; i++){
                TreeNode node = que.remove();

                levelNodes.add(node.val);

                if(node.left!=null){
                    que.add(node.left);
                }

                if(node.right!=null){
                    que.add(node.right);
                }
            }

            res.add(levelNodes);
        }
    }
}