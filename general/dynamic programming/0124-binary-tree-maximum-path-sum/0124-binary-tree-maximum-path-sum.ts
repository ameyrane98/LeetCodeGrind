function maxPathSum(root: TreeNode | null): number {
    // We use a closure so the dfs function can update this variable
    let maxSum = -Infinity; // FIXED: Handles trees where all nodes are negative

    function dfs(node: TreeNode | null): number {
        if (node === null) return 0;

        // FIXED: Traverse first, and ignore paths that evaluate to less than 0
        let left = Math.max(0, dfs(node.left));
        let right = Math.max(0, dfs(node.right));

        // Job 1: Check if the "V-shape" path here is the new global max
        maxSum = Math.max(maxSum, node.val + left + right);

        // Job 2: Pass up ONLY a straight line (root + best single child path)
        // FIXED: We do not return left + right + node.val here
        return node.val + Math.max(left, right); 
    }

    dfs(root);
    return maxSum;
}