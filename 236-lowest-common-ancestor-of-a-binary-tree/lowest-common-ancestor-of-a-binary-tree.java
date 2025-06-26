class Solution {

    List<TreeNode> lst1 = new ArrayList<>(); 
    List<TreeNode> lst2 = new ArrayList<>(); 

    boolean flag = false;
    boolean flag2 = false; 
    TreeNode p, q; 

    void path(TreeNode root) {
        if (root == null || (flag && (!flag2 && lst2.get(lst2.size() - 1) == q) || (flag2 && lst2.get(lst2.size() - 1) == p))) {
            return;
        }

        if (!flag) {
            lst1.add(root);
            if (root == p || root == q) {
                flag = true;
                flag2 = (root == q);
                lst2 = new ArrayList<>(lst1);
            }
        } else {
            lst2.add(root);
        }

        path(root.left);
        path(root.right);

        if (!flag) {
            lst1.remove(lst1.size() - 1);
        } else {
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
