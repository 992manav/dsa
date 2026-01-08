class Solution {
    int MOD = 1000000007;

    long fun(TreeNode root){
        if(root == null){
            return 0;
        }

        long le = fun(root.left);
        long ri = fun(root.right);

        return le + ri + root.val;
    }

    long max = Long.MIN_VALUE;
    long sum;

    long traverse(TreeNode root){
        if(root == null){
            return 0;
        }

        long le = traverse(root.left);
        long ri = traverse(root.right);

        long prod1 = (sum - le) * le;
        long prod2 = (sum - ri) * ri;

        max = Math.max(max, prod1);
        max = Math.max(max, prod2);

        return le + ri + root.val;
    }

    public int maxProduct(TreeNode root) {
        sum = fun(root);
        traverse(root);
        return (int)(max % MOD);
    }
}
