class Solution {
    private boolean found = false;
    private List<Integer> lst = new ArrayList<>();
    private TreeNode target;
    private int dis;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.target = target;
        this.dis = k;
        path(root, k);
        return lst;
    }

    private int path(TreeNode root, int k) {
        if (root == null) return -1;

        if (root == target) found = true;

        if (k == 0 && found) {
            lst.add(root.val);
            if (dis == 0) found = false;
            return -2;
        }

        if (found) {
            path(root.left, k - 1);
            path(root.right, k - 1);
            return (root == target) ? k - 1 : -2;
        }

        int x = path(root.left, k);
        if (x != -1) {
            if (x == 0) {
                lst.add(root.val);
                return -2;
            }
            if (x == -2) found = false;
            path(root.right, x - 1);
            return x - 1;
        }

        int y = path(root.right, k);
        if (y != -1) {
            if (y == 0) {
                lst.add(root.val);
                return -2;
            }
            if (y == -2) found = false;
            path(root.left, y - 1);
            return y - 1;
        }

        return -1;
    }
}
