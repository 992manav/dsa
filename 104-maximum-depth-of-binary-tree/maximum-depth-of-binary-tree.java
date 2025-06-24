class Solution {

    int height(TreeNode root){
    if (root == null) return 0;

    int left = height(root.left);
    int right = height(root.right);

    if (left > right) {
        return 1 + left;
    } else {
        return 1 + right;
    }
}


    public int maxDepth(TreeNode root) {
        return height(root);
    }
}