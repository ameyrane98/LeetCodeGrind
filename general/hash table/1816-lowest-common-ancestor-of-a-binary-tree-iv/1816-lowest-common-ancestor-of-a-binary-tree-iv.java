class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> nodeSet = new HashSet<>();
        for (TreeNode node : nodes) {
            nodeSet.add(node.val);
        }

        return helper(root, nodeSet);
    }

    private TreeNode helper(TreeNode root, Set<Integer> nodeSet) {
        if (root == null) return null;

        if (nodeSet.contains(root.val)) return root;

        TreeNode left = helper(root.left, nodeSet);
        TreeNode right = helper(root.right, nodeSet);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
