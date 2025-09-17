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
    public int amountOfTime(TreeNode root, int start) {
        int minutes=0;
        if(root==null){
            return minutes;
        }
        HashMap<TreeNode, TreeNode> parent= new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode startNode = build(root,start,parent);

        if (startNode == null) return 0;

        que.offer(startNode);
        visited.add(startNode);

        while(!que.isEmpty()){
            int n= que.size();
            boolean spread = false;
            for(int i=0; i<n; i++){
                 TreeNode nd = que.poll();

            if(nd.left!=null){
                if(!visited.contains(nd.left)){
                    visited.add(nd.left);
                    que.offer(nd.left);
                    spread=true;
                }
            }
            if(nd.right!=null){
                if(!visited.contains(nd.right)){
                    visited.add(nd.right);
                    que.offer(nd.right);
                    spread=true;
                }
            }

            TreeNode p = parent.get(nd);
            if(p!=null && !visited.contains(p)){
                visited.add(p);
                que.offer(p);
                spread=true;
            }
            }
           if(spread){
                minutes++;
           }
        }


        return minutes;
    }

    public TreeNode build(TreeNode root, int start, HashMap<TreeNode,TreeNode> parent){
       Queue<TreeNode> que = new LinkedList<>();
       que.offer(root);
       TreeNode startNode = null;

       while(!que.isEmpty()){
            TreeNode node = que.poll();

            if(node.val==start){
                startNode= node;
            }

            if(node.left!=null){
                parent.put(node.left,node);
                que.offer(node.left);
            }


            if(node.right!=null){
                parent.put(node.right,node);
                que.offer(node.right);
            }
       }

        return startNode;
    }
}