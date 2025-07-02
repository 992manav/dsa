import java.util.*;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;

        List<Integer> lst = new ArrayList<>();
        while (node != null) {

            TreeNode temp = node.left;

            if (temp != null) {
                while (temp.right != null && temp.right != node) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = node;
                    node = node.left;
                } else {
                    temp.right = null;
                    lst.add(node.val);
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
