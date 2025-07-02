class Solution {

    TreeNode result;

    boolean check(TreeNode root, int left, int right, int target, int target2) {
        if (root == null) return false;

        int rootVal = root.val;

        if (rootVal == target) {
            if (target2 > left && target2 < right) {
                result = root;
                return true;
            }
        } else if (rootVal > target) {
            if (!check(root.left, left, rootVal, target, target2)) {
                if (target2 >= rootVal && target2 < right) {
                    result = root;
                    return true;
                }
            } else {
                return true;
            }
        } else {
            if (!check(root.right, rootVal, right, target, target2)) {
                if (target2 >= left && target2 < rootVal) {
                    result = root;
                    return true;
                }
            } else {
                return true;
            }
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        check(root, Integer.MIN_VALUE, Integer.MAX_VALUE, Math.min(pVal, qVal), Math.max(pVal, qVal));

        return result;
    }
}
