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

    List<List<Integer>> final_lst = new ArrayList<>();

    void bfs(Queue<TreeNode> q, Queue<TreeNode> q2) {
        if (q.isEmpty()) return;

        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            level.add(node.val);

            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);
        }

        final_lst.add(level);
        bfs(q2, new LinkedList<>()); // recurse to next level
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return final_lst;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        bfs(q, new LinkedList<>());

        return final_lst;
    }
}
