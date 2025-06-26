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

        Stack<Pair> st = new Stack<>();
        Queue<Pair> q = new LinkedList<>();

        while (!dq.isEmpty()) {
            int len = dq.size();

            while (len > 0) {
                if (len == 1) {
                    Pair p = dq.remove();
                    if (p.party != 'r') return false;

                    if (p.node.left != null)
                        dq.addLast(new Pair(p.node.left, -1, 'L'));
                    if (p.node.right != null)
                        dq.addLast(new Pair(p.node.right, 1, 'R'));

                    len--;
                    continue;
                }

                Pair first = dq.removeFirst();
                Pair last = dq.removeLast();
                len -= 2;

                // Check symmetry
                if (first.party != 'L' || last.party != 'R' ||
                        first.dir == last.dir || first.node.val != last.node.val) {
                    System.out.println(first.node.val);
                    System.out.println(last.node.val);
                    System.out.println(first.dir);
                    System.out.println(last.dir);
                    System.out.println(first.party);
                    System.out.println(last.party);
                    return false;
                }

                // Left child of first, right child of last
                if ((first.node.left == null) != (last.node.right == null)) {
                    return false;
                }
                if (first.node.left != null) {
                    q.add(new Pair(first.node.left, -1, 'L'));
                }
                if (last.node.right != null) {
                    st.push(new Pair(last.node.right, 1, 'R'));
                }

                // Right child of first, left child of last
                if ((first.node.right == null) != (last.node.left == null)) {
                    return false;
                }
                if (first.node.right != null) {
                    q.add(new Pair(first.node.right, 1, 'L'));
                }
                if (last.node.left != null) {
                    st.push(new Pair(last.node.left, -1, 'R'));
                }
            }

            // ✅ Fixed this line
            while (!q.isEmpty()) {
                dq.addLast(q.remove());
            }

            while (!st.isEmpty()) {
                dq.addLast(st.pop());
            }
        }

        return true;
    }
}
