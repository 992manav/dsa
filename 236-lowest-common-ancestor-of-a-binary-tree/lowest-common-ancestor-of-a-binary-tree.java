/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<TreeNode> lst1 = new ArrayList<>();
    List<TreeNode> lst2 = new ArrayList<>();
    
    boolean found = false; // shared flag

    TreeNode target; // shared target node

    // This function finds path to target and stores it in lst1 or lst2 based on use
    void path(TreeNode root, List<TreeNode> lst) {
        if (root == null || found) return;

        lst.add(root);

        if (root == target) {
            found = true;
            return;
        }

        path(root.left, lst);
        path(root.right, lst);

        if (!found) {
            lst.remove(lst.size() - 1); // backtrack if not found
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Find path to p
        this.found = false;
        this.target = p;
        path(root, lst1);

        // Find path to q
        this.found = false;
        this.target = q;
        path(root, lst2);

        // Compare both paths
        TreeNode lca = null;
        int i = 0;
        while (i < lst1.size() && i < lst2.size()) {
            if (lst1.get(i) == lst2.get(i)) {
                lca = lst1.get(i);
            } else {
                break;
            }
            i++;
        }

        return lca;
    }
}
