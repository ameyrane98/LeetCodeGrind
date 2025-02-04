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
    /** my solution using the effect on inorder traversal on bst */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList();
        solve(root,arr);
        return arr.get(k-1);
    }

    public void solve(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
     
      solve(root.left,arr);
      arr.add(root.val);
      solve(root.right,arr);
    }

    /**OPTIMIZED WITH SPACE OF O(1) */
    // class Solution {
    // private int count = 0;
    // private int result = -1;

    // public int kthSmallest(TreeNode root, int k) {
    //     inorderTraversal(root, k);
    //     return result;
    // }

    // private void inorderTraversal(TreeNode root, int k) {
    //     if (root == null) {
    //         return;
    //     }

    //     // Traverse the left subtree
    //     inorderTraversal(root.left, k);

    //     // Increment the count of visited nodes
    //     count++;

    //     // If we've reached the kth node, store the result
    //     if (count == k) {
    //         result = root.val;
    //         return;
    //     }

    //     // Traverse the right subtree
    //     inorderTraversal(root.right, k);
    // }
}

