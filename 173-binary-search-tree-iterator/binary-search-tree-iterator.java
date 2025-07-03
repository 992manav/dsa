class BSTIterator {

    Stack<TreeNode> st = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        pushAllLeft(node.right); 
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}
