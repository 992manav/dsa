class Solution {
    public boolean isSymmetric(TreeNode root) {
        class Pair {
            TreeNode node;
            byte party; // 0 = L, 1 = R, 2 = root

            Pair(TreeNode node, byte party) {
                this.node = node;
                this.party = party;
            }
        }

        if (root == null) return true;

        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(root, (byte) 2));

        Deque<Pair> st = new ArrayDeque<>();
        Deque<Pair> q = new ArrayDeque<>();

        while (!dq.isEmpty()) {
            int len = dq.size();

            while (len > 0) {
                if (len == 1) {
                    Pair p = dq.poll();
                    if (p.party != 2) return false;

                    if (p.node.left != null)
                        dq.addLast(new Pair(p.node.left, (byte) 0));
                    if (p.node.right != null)
                        dq.addLast(new Pair(p.node.right, (byte) 1));

                    len--;
                    continue;
                }

                Pair first = dq.pollFirst();
                Pair last = dq.pollLast();
                len -= 2;

                if (first.party != 0 || last.party != 1 || first.node.val != last.node.val)
                    return false;

                if ((first.node.left == null) != (last.node.right == null)) return false;
                if (first.node.left != null) q.add(new Pair(first.node.left, (byte) 0));
                if (last.node.right != null) st.push(new Pair(last.node.right, (byte) 1));

                if ((first.node.right == null) != (last.node.left == null)) return false;
                if (first.node.right != null) q.add(new Pair(first.node.right, (byte) 0));
                if (last.node.left != null) st.push(new Pair(last.node.left, (byte) 1));
            }

            while (!q.isEmpty()) dq.addLast(q.poll());
            while (!st.isEmpty()) dq.addLast(st.pop());
        }

        return true;
    }
}
