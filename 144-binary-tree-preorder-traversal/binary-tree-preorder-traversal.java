/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<Integer> lst = new ArrayList<>();

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        lst.add(root.val);      // root
        preorder(root.left);    // left
        preorder(root.right);   // right
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);  
        return lst;
    }
}
