class Solution {
    // root left right
    boolean preorder(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        //koi ek null 6

        if (root1 == null || root2 == null) {
            return false;
        }

        //banne null nathi 

        if (root1.val != root2.val) {
            return false;
        }

        
        return preorder(root1.left, root2.left) && preorder(root1.right, root2.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preorder(p, q);
    }
}
