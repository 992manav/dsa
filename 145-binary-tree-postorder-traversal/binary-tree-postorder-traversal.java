class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> lst = new ArrayList<>();

        if (root == null) return lst;

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.peek();

            if (node.left != null) {
                st.push(node.left);
                node.left = null;
                continue;
            }

            // jeno left nathi

            if (node.right != null) {
                st.push(node.right);
                node.right = null;
                continue;
            }

            // jeno right nathi

            lst.add(st.pop().val);
        }

        return lst;
    }
}
