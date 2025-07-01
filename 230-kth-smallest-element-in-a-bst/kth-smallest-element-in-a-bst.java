class Solution {
    int k;
    int result = -1;
    boolean found = false;

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (found) return;

        k--;
        if (k == 0) {
            found = true;
            result = root.val;
            return;
        }

        inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result;
    }
}
