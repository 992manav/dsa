class Solution {

    boolean found = false;
    int k;

    int inorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = inorder(root.left);
        if (found) return left;

        k--;
        if (k == 0) {
            found = true;
            return root.val;
        }

        int right = inorder(root.right);
        if (found) return right;

        return 0; // default return if not found
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k; // assign k to instance variable
        return inorder(root);
    }
}
