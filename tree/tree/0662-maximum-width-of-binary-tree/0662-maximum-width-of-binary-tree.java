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
    /** idea:
     * one every level check if we have atleast two nodes that is que.size() >=2 else skip
     *  width = 2^d where d is depth or level, we need to keep level count
        1 to 
        we can have pos of nodes too left is when we put is que for left or right for null
     */
    public int widthOfBinaryTree(TreeNode root) {
        

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root,0));
        int maxWidth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            int levelStart = que.peek().idx; // startIdx at particular leve
            int levelEnd = levelStart; 
            
            for(int i=0; i<size; i++){
                Pair p = que.poll();
                levelEnd = p.idx;
                if(p.node.left!=null){
                    que.offer(new Pair(p.node.left,2 * p.idx + 1));
                }
                if(p.node.right!=null){
                    que.offer(new Pair(p.node.right,2 * p.idx + 2));
                }

                maxWidth= Math.max(maxWidth,levelEnd-levelStart+1);
            }
            
            
        }

        return maxWidth;
    }

    class Pair{
       TreeNode node;
        int idx;
        Pair(TreeNode node, int idx) 
        { this.node = node; this.idx = idx; }
        }
    
}