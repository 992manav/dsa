class Solution {

    void travel(TreeNode root, long index, int level, List<Long> leftMost, List<Long> rightMost) {
        if (root == null) return;

        // Leftmost check
        if (leftMost.size() <= level) {
            leftMost.add(index);
        }

        // Rightmost check
        if (rightMost.size() <= level) {
            rightMost.add(index);
        } else {
            if (rightMost.get(level) < index) {
                rightMost.set(level, index);
            }
        }

        travel(root.left, 2L * index, level + 1, leftMost, rightMost);
        travel(root.right, 2L * index + 1, level + 1, leftMost, rightMost);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        List<Long> leftMost = new ArrayList<>();
        List<Long> rightMost = new ArrayList<>();

        travel(root, 1L, 0, leftMost, rightMost);

        long maxWidth = 0;
        for (int i = 0; i < leftMost.size(); i++) {
            maxWidth = Math.max(maxWidth, rightMost.get(i) - leftMost.get(i) + 1);
        }

        return (int) maxWidth;
    }
}
