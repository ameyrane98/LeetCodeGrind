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
        Queue<TreeNode> que= new LinkedList<>();
         TreeNode startNode = buildParentAndFind(root, parent, start);
        if (startNode == null) return 0;
        Set<TreeNode> visited= new HashSet<>();
        que.offer(startNode);
        visited.add(startNode);

        while(!que.isEmpty()){
            int n= que.size();
            boolean spread = false;
            for(int i=0; i<n; i++){
                TreeNode node = que.poll();

                if(node.left!=null && !visited.contains(node.left)){
                   que.offer(node.left);
                   visited.add(node.left);
                         spread = true;
                }
                if(node.right!=null && !visited.contains(node.right)){
                   que.offer(node.right);
                    visited.add(node.right);
                          spread = true;
                }
                TreeNode p = parent.get(node);
                if(p!=null && !visited.contains(p)){
                    que.offer(p);
                        visited.add(p);
                    spread = true;
                }
            }
            if (spread) minutes++; 
        }

        return minutes;
    }

    private TreeNode buildParentAndFind(TreeNode root, Map<TreeNode, TreeNode> parent, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == start) startNode = node;

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
        return startNode;
    }


}