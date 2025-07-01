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

    // Direction constants
    static final int LEFT = 0;
    static final int RIGHT = 1;

    void delete_one_child(TreeNode parent, TreeNode grandchild, int dir) {
        if (dir == LEFT) {
            parent.left = grandchild;
        } else {
            parent.right = grandchild;
        }
    }

    TreeNode find_max_left(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return find_max_left(root.left);
    }

    TreeNode delete(TreeNode root, int key) {
        int rootVal = root.val;

        if (rootVal < key) {
            if (root.right != null) {
                TreeNode parent = root;
                TreeNode child = root.right;

                if (child.val == key) {
                    if (child.left == null && child.right == null) {
                        parent.right = null;
                    } else if (child.left != null && child.right == null) {
                        delete_one_child(parent, child.left, RIGHT);
                    } else if (child.left == null && child.right != null) {
                        delete_one_child(parent, child.right, RIGHT);
                    } else {
                        TreeNode node = find_max_left(child.right);
                        int value = node.val;
                        delete(parent, value);
                        child.val = value;
                    }
                } else {
                    delete(child, key);
                }

            } else {
                return root;
            }

        } else if (rootVal > key) {
            if (root.left != null) {
                TreeNode parent = root;
                TreeNode child = root.left;

                if (child.val == key) {
                    if (child.left == null && child.right == null) {
                        parent.left = null;
                    } else if (child.left != null && child.right == null) {
                        delete_one_child(parent, child.left, LEFT);
                    } else if (child.left == null && child.right != null) {
                        delete_one_child(parent, child.right, LEFT);
                    } else {
                        TreeNode node = find_max_left(child.right);
                        int value = node.val;
                        delete(parent, value);
                        child.val = value;
                    }
                } else {
                    delete(child, key);
                }

            } else {
                return root;
            }
        } else {
            // root.val == key
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode node = find_max_left(root.right);
                int value = node.val;
                delete(root, value);
                root.val = value;
                return root;
            }
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return delete(root, key);
    }
}
