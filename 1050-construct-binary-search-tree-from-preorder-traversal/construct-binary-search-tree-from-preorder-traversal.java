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
import java.util.Arrays;

class Solution {

    int search(int target, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    TreeNode buildTree(int[] pre, int[] in, int left_bound, int right_bound, int index) {
        if (left_bound > right_bound || index >= pre.length) return null;

        TreeNode root = new TreeNode(pre[index]);
        int inorder_index = search(root.val, in);

        root.left = buildTree(pre, in, left_bound, inorder_index - 1, index + 1);
        root.right = buildTree(pre, in, inorder_index + 1, right_bound, index + (inorder_index - left_bound) + 1);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0);
    }
}
