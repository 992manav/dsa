/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int index = 0;  

    private TreeNode buildTree(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);

        root.left = buildTree(preorder, val);         // Left subtree: values < val
        root.right = buildTree(preorder, upperBound); // Right subtree: values > val but < upperBound

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MAX_VALUE);
    }
}
