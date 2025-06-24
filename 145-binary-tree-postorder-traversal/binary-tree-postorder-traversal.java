class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> lst = new ArrayList<>();

        if (root == null) return lst;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);
        // left right node -> ulata Node right left
        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);

            if (node.left != null) {
                st1.push(node.left);
            }

            
            if (node.right != null) {
                st1.push(node.right);
            }


        }

        while (!st2.isEmpty()) {
            lst.add(st2.pop().val);
        }

        return lst;
    }
}
