class Solution {

    int maxsum = Integer.MIN_VALUE; 

    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_sum = sum(root.left);
        int right_sum = sum(root.right);

       

       if(left_sum>=0 && right_sum>=0){
            maxsum = Math.max(maxsum, left_sum + right_sum + root.val); 
       }else if(left_sum>=0 && right_sum<=0){
            maxsum = Math.max(maxsum, left_sum +  root.val); 
       }else if(right_sum>=0 && left_sum<=0){
            maxsum = Math.max(maxsum, right_sum + root.val); 
       }else{
            maxsum = Math.max(maxsum, root.val); 
       }

      

        return Math.max(root.val,root.val + Math.max(left_sum, right_sum));
    }

    public int maxPathSum(TreeNode root) {
        sum(root); 
        return maxsum;
    }
}
