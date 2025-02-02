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
    // O(n * m)
   private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null) {
            return false;
        }
        if (isSameTree(p, q)) {
            return true;
        }
        return helper(p.left, q) || helper(p.right, q);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot);
    }

}


/** way to use Serializaiton O(n+m) */
// class Solution {
//     private String serialize(TreeNode node) {
//         if (node == null) {
//             return "N";
//         }
//         return "(" + node.val + "," + serialize(node.left) + "," + serialize(node.right) + ")";
//     }

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String rootSerialized = serialize(root);
//         String subRootSerialized = serialize(subRoot);
//         return rootSerialized.contains(subRootSerialized);
//     }
// }