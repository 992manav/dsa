import java.util.*;

class Solution {

    long targetSum;
    long count = 0;

    void fun(TreeNode node, long path_sum, Map<Long, Long> map) {

        long check_sum = path_sum - targetSum;

        if (map.containsKey(check_sum)) {
            count += map.get(check_sum);
        }

        map.put(path_sum, map.getOrDefault(path_sum, 0L) + 1L);

        if (node.left != null) {
            fun(node.left, path_sum + node.left.val, map);
        }

        if (node.right != null) {
            fun(node.right, path_sum + node.right.val, map);
        }

        map.put(path_sum, map.get(path_sum) - 1L);

        if (map.get(path_sum) == 0L) {
            map.remove(path_sum);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {

        this.targetSum = targetSum;

        if (root == null) {
            return 0;
        }

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        fun(root, root.val, map);

        return (int) count;
    }
}
