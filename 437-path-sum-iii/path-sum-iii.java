import java.util.*;

class Solution {

    long targetSum;
    long count = 0;

    // DFS function – prefix sum use kari ne path count kare chhe
    void fun(TreeNode node, long path_sum, Map<Long, Long> map) {

        // Check kariye ke (current sum - targetSum) pehle aavyo chhe ke nahi
        long check_sum = path_sum - targetSum;

        if (map.containsKey(check_sum)) {
            // Jetli vaar aavyo hoy etla valid paths add kariye
            count += map.get(check_sum);
        }

        // Current path_sum map ma add kariye
        map.put(path_sum, map.getOrDefault(path_sum, 0L) + 1L);

                    // Left subtree taraf DFS
                    if (node.left != null) {
                        fun(node.left, path_sum + node.left.val, map);
                    }

                    // Right subtree taraf DFS
                    if (node.right != null) {
                        fun(node.right, path_sum + node.right.val, map);
                    }

        // Backtrack: aa node nu contribution hataavi devu
        map.put(path_sum, map.get(path_sum) - 1L);
        if (map.get(path_sum) == 0L) {
            map.remove(path_sum);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {

        // Target sum store kariye
        this.targetSum = targetSum;

        // Tree empty hoy to answer 0
        if (root == null) {
            return 0;
        }

        // Prefix sum map: sum -> frequency
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); // base case

        // Root thi DFS start kariye
        fun(root, root.val, map);

        return (int) count;
    }
}
