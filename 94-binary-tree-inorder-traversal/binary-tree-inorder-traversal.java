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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();

        if (root == null) return lst; 

        st.push(root);
        //left root right

        while (!st.isEmpty()) {
            TreeNode node = st.peek();

            if (node.left != null) {
                st.push(node.left);
                node.left=null;
                continue;
            }

            lst.add(st.pop().val);

            if (node.right != null) {
                st.push(node.right);
            }

            
        }

        return lst;
    }
}
