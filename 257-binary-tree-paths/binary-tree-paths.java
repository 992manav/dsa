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

    List<String> lst = new ArrayList<>();

    void travel(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            lst.add(sb.toString());
            return;
        }

        if (root.left != null) {
            int original_len = sb.length();
            sb.append("->");
            sb.append(root.left.val);
            travel(root.left, sb);
            sb.delete(original_len, sb.length());
        }

        if (root.right != null) {
            int original_len = sb.length();
            sb.append("->");
            sb.append(root.right.val);
            travel(root.right, sb);
            sb.delete(original_len, sb.length());
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return lst;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        travel(root, sb);
        return lst;
    }
}
