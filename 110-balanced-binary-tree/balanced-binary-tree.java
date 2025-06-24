class Solution {

    boolean flag = false;

    int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (left > right) {
            if (left - right > 1) {
                flag = true;
                return -1; // fixed: return dummy value
            }

            return left + 1;

        } else {
            if (right - left > 1) {
                flag = true;
                return -1; // fixed: return dummy value
            }

            return right + 1;
        }

    }

    public boolean isBalanced(TreeNode root) {
        height(root);
        return !flag;
    }
}
