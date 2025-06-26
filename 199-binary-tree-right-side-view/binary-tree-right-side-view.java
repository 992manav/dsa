class Solution {
    List<Integer> lst = new ArrayList<>();
    int max_level = 0;

    void travel_right(TreeNode root, int level) {
        if (root == null) return;

        if (level > max_level) {
            lst.add(root.val);
            max_level = level; 
        }

        travel_right(root.right, level + 1);
        travel_right(root.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        travel_right(root, 1);
        return lst;
    }
}