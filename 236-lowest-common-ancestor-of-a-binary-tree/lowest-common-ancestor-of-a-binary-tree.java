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

    boolean flag = false;
    boolean flag2 = false;  // FIXED: typo "boolen" to "boolean"
    TreeNode p, q; 

    void path(TreeNode root) {
        if (root == null) {
            return;
        }

        if (!flag) {
            lst1.add(root);
            
            if (root == q) {
                flag = true;
                flag2 = true;
                lst2 = new ArrayList<>(lst1); 
            }

            if (root == p) {
                flag = true;   
                lst2 = new ArrayList<>(lst1);
            }

        } else {
            lst2.add(root);

            if (flag2) {  // q was found first
                if (root == p) return;
            } else {      // p was found first
                if (root == q) return;
            }
        }

        path(root.left);
        path(root.right);

        if (!flag) {
            lst1.remove(lst1.size() - 1);
        } else {
            // Only remove if p or q not found yet after flag
            if ((flag2 && lst2.get(lst2.size() - 1) != p) || (!flag2 && lst2.get(lst2.size() - 1) != q)) {
                lst2.remove(lst2.size() - 1);
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;

        path(root);

        int i = 0;
        TreeNode lca = null;

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
