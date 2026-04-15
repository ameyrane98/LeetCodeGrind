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
    Queue<TreeNode> que = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return result;
        }

        que.offer(root);

        while(!que.isEmpty()){
            int level = que.size();
            for(int i=0; i<level; i++){
                TreeNode data = que.poll();

                if(i == level-1){
                    result.add(data.val);
                }

                if(data.left!=null){
                    que.offer(data.left);
                }

                if(data.right!=null){
                    que.offer(data.right);
                }
            }


        }

        return result;
    }


}