/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function diameterOfBinaryTree(root: TreeNode | null): number {

    let max=0;
function heightTree(root: TreeNode | null): number{
    if(root==null){
        return 0;
    }
    

    let left = heightTree(root.left);
    let right = heightTree(root.right);
    max= Math.max(max, left+right);

    return Math.max(left,right)+1
}

    heightTree(root);
    return max;
    
};

