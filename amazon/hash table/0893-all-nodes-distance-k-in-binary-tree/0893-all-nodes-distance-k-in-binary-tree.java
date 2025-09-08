/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
      
        if (root == null || target == null) return result;
        if (k == 0) { result.add(target.val); return result; }

        // to track parent pointer, we use map
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        HashSet<TreeNode> visited= new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
    
        inorder(root,map);
        que.add(target);
        visited.add(target);

        int dist = 0;
        while(!que.isEmpty()){
            int n=que.size();
            if (dist == k) {
                // Everything currently in the queue is at distance k
                for (TreeNode node : que) result.add(node.val);
                return result;
            }

            for(int i=0;i<n;i++){
                TreeNode node = que.poll();
                
                if(node.left!=null){
                    if(!visited.contains(node.left)){
                        que.add(node.left);
                        visited.add(node.left);
                    }
                    
                }
                if(node.right!=null){
                    if(!visited.contains(node.right)){
                        que.add(node.right);
                        visited.add(node.right);
                    }
                }

                TreeNode p = map.get(node);
                if (p != null && !visited.contains(p)) {
                    que.offer(p);
                    visited.add(p);
                }
            }
            dist++;
        }

    return result;
    }

    public void inorder(TreeNode root,Map<TreeNode, TreeNode> map){
      if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        inorder(root.left, map);
        inorder(root.right, map);
    }
}