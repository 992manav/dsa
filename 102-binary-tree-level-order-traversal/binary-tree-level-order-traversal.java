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

    Queue<TreeNode> q = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> final_lst = new ArrayList<>();

        if (root == null) return final_lst;

        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.remove();
                level.add(node.val);

                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }

            final_lst.add(level);

            // swap queues
            Queue<TreeNode> temp = q;
            q = q2;
            q2 = temp;
        }

        return final_lst;
    }
}
