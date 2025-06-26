/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FoundException extends RuntimeException {}  // Custom exception for early exit

class Solution {

    List<TreeNode> lst1 = new ArrayList<>();
    List<TreeNode> lst2 = new ArrayList<>();
    TreeNode p, q;

    void path(TreeNode root, TreeNode target, List<TreeNode> pathList) {
        if (root == null) return;

        pathList.add(root);

        if (root == target) {
            throw new FoundException();  // Early exit when target found
        }

        path(root.left, target, pathList);
        path(root.right, target, pathList);

        pathList.remove(pathList.size() - 1); // backtrack
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;

        try {
            path(root, p, lst1);
        } catch (FoundException e) {
            // path to p found and stored in lst1
        }

        try {
            path(root, q, lst2);
        } catch (FoundException e) {
            // path to q found and stored in lst2
        }

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
