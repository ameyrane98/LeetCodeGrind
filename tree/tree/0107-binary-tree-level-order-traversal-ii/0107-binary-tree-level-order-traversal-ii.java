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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /** Idea
             - return the bottom level order
         */

        if(root==null){
            return new LinkedList<>();
        }

        Queue<TreeNode> que = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        que.add(root);


        while(!que.isEmpty()){
            int level = que.size();
            List<Integer> levelNodes = new LinkedList<>();
            for(int i=0; i<level; i++){
                TreeNode node = que.poll();
                levelNodes.add(node.val);

                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }


            }

            stack.add(levelNodes);
        }

        List<List<Integer>> res= new LinkedList<>();

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }
}