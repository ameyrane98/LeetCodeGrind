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
            Pair p = que.poll();
            if(map.containsKey(p.col)){
                map.get(p.col).add(p.Node.val);
            }else{
                List<Integer> list = new LinkedList<>();
                list.add(p.Node.val);
                map.put(p.col, list);
            }

            minCol= Math.min(minCol,p.col);
            maxCol= Math.max(maxCol,p.col);
            if(p.Node.left!=null){
                que.add(new Pair(p.Node.left,p.col-1));
            }

            if(p.Node.right!=null){
                que.add(new Pair(p.Node.right,p.col+1));
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