class Solution {
    TreeNode lcaNode;
    boolean findLCA(TreeNode node, int minBound, int maxBound, int small, int large) {
        if (node == null) return false;

        int val = node.val;

        if (val == small) {
            if (large > minBound && large < maxBound) {
                lcaNode = node;
                return true;
            }
        } else if (val > small) {
            if (!findLCA(node.left, minBound, val, small, large)) {
                if (large >= val && large < maxBound) {
                    lcaNode = node;
                    return true;
                }
            } else return true;
        } else { 
                findLCA(node.right, val, maxBound, small, large);
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = p.val;
        int val2 = q.val;

        int small = Math.min(val1, val2);
        int large = Math.max(val1, val2);

        findLCA(root, Integer.MIN_VALUE, Integer.MAX_VALUE, small, large);

        return lcaNode;
    }
}
