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
import java.util.*;

class Solution {

    Map<TreeNode, TreeNode> map = new HashMap<>();
    TreeNode target;
    int start;

    // DFS: Build parent map and locate target node
    void dfs(TreeNode parent, TreeNode child) {
        if (child == null) return;

        if (child.val == start) {
            target = child;
        }

        map.put(child, parent);

        dfs(child, child.left);
        dfs(child, child.right);
    }

    // BFS: Spread infection and count time
    int bfs(TreeNode root, Queue<TreeNode> q) {
        q.add(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);

        int time = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = q.remove();

                if (map.get(node) != null && !visited.contains(map.get(node))) {
                    q.add(map.get(node));
                    visited.add(map.get(node));
                }

                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
            }

            if (!q.isEmpty()) {
                time++;
            }
        }

        return time;
    }

    public int amountOfTime(TreeNode root, int start) {
        // Edge Case 1: Tree is empty
        if (root == null) return 0;

        // Edge Case 2: Only one node
        if (root.left == null && root.right == null) return 0;

        this.start = start;
        dfs(null, root);

        Queue<TreeNode> q = new LinkedList<>();
        return bfs(target, q);
    }
}
