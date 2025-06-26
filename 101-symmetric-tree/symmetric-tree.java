class Pair {
    TreeNode node;
    int dir;
    char party;

    Pair(TreeNode node, int dir, char party) {
        this.node = node;
        this.dir = dir;
        this.party = party;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(root, 0, 'r'));

        Deque<Pair> st = new ArrayDeque<>();
        Deque<Pair> q = new ArrayDeque<>();

        while (!dq.isEmpty()) {
            int len = dq.size();

            while (len > 0) {
                if (len == 1) {
                    Pair p = dq.poll();
                    if (p.party != 'r') return false;

                    if (p.node.left != null)
                        dq.addLast(new Pair(p.node.left, -1, 'L'));
                    if (p.node.right != null)
                        dq.addLast(new Pair(p.node.right, 1, 'R'));

                    break; // no need to decrement and continue
                }

                Pair first = dq.pollFirst();
                Pair last = dq.pollLast();
                len -= 2;

                if (first.party != 'L' || last.party != 'R' ||
                    first.dir == last.dir || first.node.val != last.node.val) {
                    return false;
                }

                if ((first.node.left == null) != (last.node.right == null)) return false;
                if (first.node.left != null) q.addLast(new Pair(first.node.left, -1, 'L'));
                if (last.node.right != null) st.push(new Pair(last.node.right, 1, 'R'));

                if ((first.node.right == null) != (last.node.left == null)) return false;
                if (first.node.right != null) q.addLast(new Pair(first.node.right, 1, 'L'));
                if (last.node.left != null) st.push(new Pair(last.node.left, -1, 'R'));
            }

            dq.addAll(q);
            q.clear();

            while (!st.isEmpty()) dq.addLast(st.pop());
        }

        return true;
    }
}
