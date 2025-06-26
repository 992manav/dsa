class Solution {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode n, int idx) {
            node = n;
            index = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index; // normalize index to prevent overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                int idx = current.index - minIndex;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (current.node.left != null) {
                    q.offer(new Pair(current.node.left, 2 * idx));
                }
                if (current.node.right != null) {
                    q.offer(new Pair(current.node.right, 2 * idx + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
