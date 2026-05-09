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
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {

        if (root == null) return res;

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        Queue<Pair> que = new LinkedList();
        que.add(new Pair(root,0));

        int minCol=0;
        int maxCol=0;
        while(!que.isEmpty()){
            Pair node = que.poll();
            if(map.containsKey(node.col)){
                map.get(node.col).add(node.Node.val);
            }else{
                List<Integer> list = new LinkedList<>();
                list.add(node.Node.val);
                map.put(node.col, list);
            }

            minCol= Math.min(minCol,node.col);
            maxCol= Math.max(maxCol,node.col);
            if(node.Node.left!=null){
                que.add(new Pair(node.Node.left,node.col-1));
            }

            if(node.Node.right!=null){
                que.add(new Pair(node.Node.right,node.col+1));
            }
        }

        for(int i=minCol; i<=maxCol; i++){
            res.add(map.get(i));
        }

        return res;
    }


    class Pair{
        TreeNode Node;
        int col;
        Pair(TreeNode node, int col){
            this.Node= node;
            this.col= col;
        }
    }
}