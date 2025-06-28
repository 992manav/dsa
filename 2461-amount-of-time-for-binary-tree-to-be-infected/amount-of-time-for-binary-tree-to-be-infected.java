class Solution {

    int below_max = 0;
    int depth_target = 0;
    int target_val;
    int max_path_sum = 0;

    int height(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left, level + 1);
        int right = height(root.right, level + 1);

        if (root.val == target_val) {
            below_max = Math.max(left, right);
            depth_target = level;
            return -1; // marker: found target node
        }

        // If left or right subtree contains target node
        if (left < 0) {
            int distFromTarget = -left;
            max_path_sum = Math.max(max_path_sum, distFromTarget + right);
            return left - 1;
        }

        if (right < 0) {
            int distFromTarget = -right;
            max_path_sum = Math.max(max_path_sum, distFromTarget + left);
            return right - 1;
        }

        return Math.max(left, right) + 1;
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;

        if (root.val == start && root.left == null && root.right == null) return 0;

        target_val = start;
        height(root, 0);

        return Math.max(below_max, max_path_sum);
    }
}
