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



    /**DFS Soolution */
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> list=new ArrayList<>();
    //     right(root,0,list);
    //     return list;
    // }
    // public void right(TreeNode root,int lvl,List<Integer> list){
    //     if(root==null) return;
    //     if(lvl==list.size()) list.add(root.val);
    //     right(root.right,lvl+1,list);
    //     right(root.left,lvl+1,list);
    //     return;
    // }
}