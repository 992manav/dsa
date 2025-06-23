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

    int level(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(level(root.left), level(root.right)); // Fixed method name from height -> level
    }

    void find_nth_node(TreeNode root, int level, List<Integer> lst) {
        if (root == null) return; // handle null
        if (level == 1) {
            lst.add(root.val);
            return; // no need to go further
        }

        find_nth_node(root.left, level - 1, lst);
        find_nth_node(root.right, level - 1, lst);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> final_lst = new ArrayList<>();

        int height = level(root) + 1; // fixed wrong method call syntax

        for (int i = 1; i <= height; i++) { // changed i < height to i <= height to include last level
            List<Integer> lst = new ArrayList<>();
            find_nth_node(root, i, lst); // fixed method arguments
            final_lst.add(lst); // added correct list
        }

        return final_lst; // added return statement
    }
}
