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
    List<Integer> result= new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return result;
        }

        bfs(root);

        return result;
    }

    public void bfs(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while(!que.isEmpty()){
            int size=que.size();

            for(int i=0; i<size; i++){
                TreeNode node= que.remove();
                if(i== size-1){
                    result.add(node.val);
                }

                if(node.left!=null){
                    que.add(node.left);
                }

                if(node.right!=null){
                    que.add(node.right);
                }
            }
            
        }

    }
}