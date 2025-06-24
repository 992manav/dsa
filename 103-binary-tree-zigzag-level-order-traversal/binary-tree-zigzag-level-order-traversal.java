class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> final_lst = new ArrayList<>();

        if (root == null) return final_lst; // Handle null root

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while (!q.isEmpty()) {
            int len = q.size();
            flag = !flag;  // Flip the flag
            List<Integer> lst = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = q.remove();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                if (flag) {
                    lst.add(node.val);
                } else {
                    lst.add(0, node.val);  
                }
            }
            final_lst.add(lst);
        }

        return final_lst;
    }
}
