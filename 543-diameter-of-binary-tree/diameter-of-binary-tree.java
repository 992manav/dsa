class Solution {

    int maxsum = 0;

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        maxsum = Math.max(maxsum, left + right + 1);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxsum - 1; 
    }
}
