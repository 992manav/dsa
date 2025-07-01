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

    void insert(TreeNode root, int value) {
      
        int rootVal = root.val; 

        if (rootVal < value) {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new TreeNode(value);
            }
        } else {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new TreeNode(value);
            }
        }

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }
}
