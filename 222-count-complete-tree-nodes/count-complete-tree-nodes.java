class Solution {
    int count = 0;

    void dfs(TreeNode root) {
        if (root == null) return;

        count++; // visit current node

        dfs(root.left);  // go left
        dfs(root.right); // go right
    }

    public int countNodes(TreeNode root) {
        count = 0;      // initialize before DFS
        dfs(root);      // start DFS from root
        return count;   // return final count
    }
}
