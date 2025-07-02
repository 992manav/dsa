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
import java.util.*;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node = root;

        List<Integer> lst = new ArrayList<>();
        while (node != null) {
            
            
            TreeNode temp = node.left;
           
            if (temp != null) {
                while (temp.right != null && temp.right != node) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    lst.add(node.val);
                    temp.right = node;
                    node = node.left;
                } else {
                    temp.right = null;
                    node = node.right;
                }
            } else {
                lst.add(node.val);
                node = node.right;
            }
        }

        return lst;

    }
}
