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
    TreeNode p;
    TreeNode q;
    TreeNode fun(TreeNode node){

        if(node==null){
            return null;
        }

        boolean flag=false;
        if(node==p || node==q){
            flag=true;
        }

        TreeNode l=fun(node.left);
        TreeNode r=fun(node.right);

        if(l!=null && r!=null){
            return node;
        }

        if(l!=null){
            if(flag){
                return node;
            }
            return l;
        }


        if(r!=null){
            if(flag){
                return node;
            }
            return r;
        }


        if(flag){
                return node;
        }
        return null;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        TreeNode lca=fun(root);
        return lca;
    }
}