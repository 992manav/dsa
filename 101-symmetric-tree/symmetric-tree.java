class Solution {

    boolean travel(TreeNode root1, TreeNode root2) {
        // left root right
        // right root left

        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.left == null && root2.right != null) return false;
        if (root1.left != null && root2.right == null) return false;
        if (root1.right == null && root2.left != null) return false;
        if (root1.right != null && root2.left == null) return false;

        if (root1.left != null && root2.right != null && root1.left.val != root2.right.val) {
            return false;
        }

        if (root1.right != null && root2.left != null && root1.right.val != root2.left.val) {
            return false;
        }

        return travel(root1.left, root2.right) && travel(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return travel(root, root);
    }
}
