class Solution {
    List<Integer> lst = new ArrayList<>();

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        lst.add(node.val);
        inorder(node.right);
    }

    TreeNode fun(int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return new TreeNode(lst.get(l));
        }

        int mid = (l + r) / 2;

        TreeNode node = new TreeNode(lst.get(mid));
        node.left = fun(l, mid - 1);
        node.right = fun(mid + 1, r);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return fun(0, lst.size() - 1);
    }
}
