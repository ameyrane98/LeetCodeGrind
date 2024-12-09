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
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        return bfs(root);

    }

    List<List<Integer>> bfs(TreeNode root){
        Queue<TreeNode> que= new LinkedList();
       
        que.offer(root);

        while(!que.isEmpty()){
            int levesize= que.size();
          
            List<Integer> currLevel= new ArrayList<>();

          for(int i=0; i<levesize; i++){
            TreeNode dataRoot= que.poll();
            currLevel.add(dataRoot.val);

            if(dataRoot.left!=null){
              
                que.offer(dataRoot.left);
            }

            if(dataRoot.right!=null){
              
                que.offer(dataRoot.right);
            }
          }

           result.add(currLevel);
        }

        return result;
    }
}