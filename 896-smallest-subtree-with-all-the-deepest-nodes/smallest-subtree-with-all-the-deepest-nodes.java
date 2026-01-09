class Solution {

    TreeNode ans = null;
    int count;
    int max_height;

    int fun(TreeNode node, int level) {

        if (node == null) {
            return 0;
        }

        if (level == max_height) {
            if (count == 1 && ans == null) {
                ans = node;
            }
            return 1;
        }

        int lc = fun(node.left, level + 1);
        int rc = fun(node.right, level + 1);

        if (count > 1 && lc + rc == count && ans == null) {
            ans = node;
        }

        return lc + rc;
    }

    int find_count(TreeNode node, int level) {

        if (node == null) {
            return 0;
        }

        if (level == max_height) {
            return 1;
        }

        int lc = find_count(node.left, level + 1);
        int rc = find_count(node.right, level + 1);

        return lc + rc;
    }

    int find_height(TreeNode node, int level) {

        if (node == null) {
            return level - 1;
        }

        int lh = find_height(node.left, level + 1);
        int rh = find_height(node.right, level + 1);

        return Math.max(lh, rh);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        if (root == null) {
            return null;
        }

        max_height = find_height(root, 0);
        count = find_count(root, 0);

        fun(root, 0);

        return ans;
    }
}
