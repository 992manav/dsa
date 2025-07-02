class Solution {

    List<Integer> nums = new ArrayList<>();

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        // Step 1: Fill the nums list with sorted in-order traversal
        inorder(root);

        // Step 2: Use two-pointer approach
        int i = 0;
        int j = nums.size() - 1;  // ❌ FIXED: was `nums.length` — wrong for ArrayList

        while (i < j) {
            int left = nums.get(i);
            int right = nums.get(j);

            if (left + right == k) { 
                return true;
            }

            if (left + right < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
