import java.util.*;

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

    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> final_lst = new ArrayList<>();

    void bfs(Queue<TreeNode> q) {

        while (!q.isEmpty()) {
            Queue<TreeNode> q2 = new LinkedList<>();
            List<Integer> level = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.remove();
                level.add(node.val);

                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }

            final_lst.add(level);

            bfs(q2);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return final_lst;
        q.add(root);
        bfs(q);
        return final_lst;
    }
}
