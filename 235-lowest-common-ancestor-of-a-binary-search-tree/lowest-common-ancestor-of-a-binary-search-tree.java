class Solution {

    TreeNode p;
    TreeNode q;

    TreeNode fun(TreeNode node){

        if(node == null){
            return null;
        }

        if(node == p || node == q){
            return node;
        }

        TreeNode l = fun(node.left);
        TreeNode r = fun(node.right);

        if(l != null && r != null){
            return node;
        }

        if(l != null){
            return l;
        }

        return r;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return fun(root);
    }
}
