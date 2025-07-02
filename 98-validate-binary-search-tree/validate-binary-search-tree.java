class Solution {

    boolean check(TreeNode root, long range_left, long range_right) {
        if (root == null) return true;

        long rootVal = root.val;

        if (rootVal <= range_left || rootVal >= range_right) {
            return false;
        }

        return check(root.left, range_left, rootVal) && check(root.right, rootVal, range_right);
    }

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
