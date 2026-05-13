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
    public TreeNode bstFromPreorder(int[] preorder) {
        /** preorder = [8,5,1,7,10,12]

            root = 8
            [5,1,7,10,12] -sort this -> [5,1,7] [10,12] --> we need to find the split where split is greater that i,
                                        7>5 so the split is 7

            Key BST + preorder insight:
In preorder = [root, ...left subtree..., ...right subtree...]. The split point is where values become greater than root                            

                8 
                5 10.   [1] [7] [10] [12]

            eg 2
            preorder = [1,3]
                        [1] 
                        [3]
         */

        int n = preorder.length-1;
        return  solve(preorder,0,n);
    }

    TreeNode solve(int[] preorder, int i, int j){
        if (i > j) return null;

        TreeNode root = new TreeNode(preorder[i]);


        // find first index where value > root
        int split = i + 1;
        while (split <= j && preorder[split] < preorder[i]) split++;

        root.left = solve(preorder, i + 1, split - 1);
        root.right = solve(preorder, split, j);
        return root;
    }
}