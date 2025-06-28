class Solution {

    int below_max = 0;
    int depth_target = 0;
    int target_val; // store target value
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
            return -1; // marker for found target node
        }

        // Only calculate max_path_sum if we haven’t hit the target yet
        max_path_sum = Math.max(max_path_sum, Math.max(left, right) + depth_target - level);

        System.out.println("max_path_sum: " + max_path_sum);
        System.out.println("left: " + left + ", right: " + right + ", level: " + level);

        if (left == -1 || right == -1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public int amountOfTime(TreeNode root, int start) {
        // Edge case 1: empty tree
        if (root == null) return 0;

        // Edge case 2: only one node in the tree (root is the target)
        if (root.val == start && root.left == null && root.right == null) return 0;

        target_val = start;
        height(root, 0); // We don't need the return value, logic is done inside

        System.out.println("Final max_path_sum: " + max_path_sum);

        if (max_path_sum == 0) {
            return Math.max(below_max, depth_target);
        }

        return Math.max(below_max, max_path_sum);
    }
}
