class Solution {

    TreeNode p;
    TreeNode q;

    TreeNode fun(TreeNode node){

        if(node == null){
            return null;
        }

        int cur = node.val;

        if(cur == p.val || cur == q.val){
            return node;
        }

        if(cur < p.val && cur < q.val){
            return fun(node.right);  
        } 
        else if(cur > p.val && cur > q.val){
            return fun(node.left);    
        } 
        else{
            return node;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return fun(root);
    }
}
