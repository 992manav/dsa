class Solution {
    int count = 0;
    int max_level = 0;

    void dfs(TreeNode root, int level) {
        if (root == null) return;

        if (level >= max_level) {
            max_level = level;
        }

        if(root.right==null && root.left==null && level==max_level){
            return;
        }


        if (root.left == null) {
            count++;
        }
        dfs(root.left, level + 1);  // go left

        
        if (root.right == null) {  // Fixed: "rott.right = null" → "root.right == null"
            count++;
            return;
        }
          dfs(root.right, level + 1); // go right
    }

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        count = 0;           // initialize before DFS
        dfs(root, 0);        // start DFS from root

        return (int)Math.pow(2, max_level + 1) - 1-count;  // Fixed: "aMath" → "Math", and added (int) cast
    }
}
