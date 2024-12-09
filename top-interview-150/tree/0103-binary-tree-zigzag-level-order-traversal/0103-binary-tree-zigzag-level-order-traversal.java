import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        return bfs(root);
    }

    List<List<Integer>> bfs(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 0;
        
        while (!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode dataRoot = que.poll();
                
                // Add the current node value to the level list
                currLevel.add(dataRoot.val);

                // Enqueue children in standard order
                if (dataRoot.left != null) {
                    que.offer(dataRoot.left);
                }
                if (dataRoot.right != null) {
                    que.offer(dataRoot.right);
                }
            }

            // If the level is odd, reverse the current level's values
            if (level % 2 != 0) {
                Collections.reverse(currLevel);
            }

            // Add the current level to the result list
            result.add(currLevel);

            // Increment the level for the next iteration
            level += 1;
        }

        return result;
    }
}
