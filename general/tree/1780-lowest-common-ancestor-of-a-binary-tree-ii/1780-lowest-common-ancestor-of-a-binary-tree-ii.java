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
    /**
    
    Let n be the number of nodes in the binary tree.

Time complexity: O(n)

The algorithm performs two main operations:

The LCA function performs a depth-first search (DFS) to find the lowest common ancestor. In the worst case, this involves visiting all nodes, resulting in a time complexity of O(n).
The dfs function is called twice to check if one node is in the subtree of the other. Each dfs call also traverses the tree in a DFS manner, which takes O(n) in the worst case.
Since these operations are performed sequentially, the overall time complexity is O(n).

Space complexity: O(n)

The space complexity is determined by the recursion stack used during the DFS traversals. In the worst case, the tree can be a skewed tree (e.g., all nodes in a single branch), leading to a recursion depth of n. Additionally, the local variables and function calls contribute constant space, which is negligible compared to the recursion stack. Therefore, the space complexity is O(n).

 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null){
            return root;
        }
        TreeNode ans = solve(root,p,q);
        if(ans==p){
            return dfs(p,q)? p : null;
        }if (ans == q) {
            // Verify if p is in the subtree of q
            return dfs(q, p) ? q : null;
        }

        return ans;
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root == q){
            return root;
        } 


        TreeNode left= solve(root.left,p,q);
        TreeNode right= solve(root.right,p,q);

        if(left!=null & right!=null){
            return root;
        }

        return (left!=null) ? left: right;

    }

    public boolean dfs(TreeNode a, TreeNode b){
        //Verify if b is subtree of q;

        if(a==b){
            return true;
        }
        if(a==null){
            return false;
        }

        return dfs(a.left,b) || dfs(a.right,b);
    }
}