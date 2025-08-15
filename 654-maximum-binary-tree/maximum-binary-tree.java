class Solution {

    int[] nums;

    int find_max_index(int l,int r){
        int max_idx= l;
        for(int i=l;i<=r;i++){
            if(nums[i]>nums[max_idx]){
                max_idx=i;
            }
        }
        return max_idx;
    }

    TreeNode build(int l,int r){
        if(r<l ){
            return null;
        }
        int idx=find_max_index(l,r);
        int val=nums[idx];
        TreeNode node=new TreeNode(val);

        node.left=build(l,idx-1);
        node.right=build(idx+1,r);

        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return build(0, nums.length-1);
    }
}
