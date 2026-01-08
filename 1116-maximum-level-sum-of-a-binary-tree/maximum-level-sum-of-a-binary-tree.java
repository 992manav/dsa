class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int max_lev = -1;
        int max = Integer.MIN_VALUE;
        int lev = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (sum > max) {
                max = sum;
                max_lev = lev;
            }
            lev++;
        }

        return max_lev;
    }
}
