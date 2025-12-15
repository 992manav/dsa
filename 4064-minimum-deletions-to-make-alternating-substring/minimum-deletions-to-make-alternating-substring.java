import java.util.*;

class Solution {

    int[] seg;
    char[] first;
    char[] last;
    int n;

    int ans;
    char common_point;
    boolean taken;

    void build(int index, int l, int r, char[] s) {
        if (l == r) {
            first[index] = s[l];
            last[index] = s[l];
            seg[index] = 0;
            return;
        }

        int mid = (l + r) / 2;

        int left_child_index = 2 * index;
        int right_child_index = 2 * index + 1;

        build(left_child_index, l, mid, s);
        build(right_child_index, mid + 1, r, s);

        first[index] = first[left_child_index];
        last[index] = last[right_child_index];

        seg[index] = seg[left_child_index] + seg[right_child_index];
        if (last[left_child_index] == first[right_child_index]) {
            seg[index]++;
        }
    }

    void update(int index, int l, int r, int pos) {
        if (l == r) {
            first[index] = last[index] = (first[index] == 'A') ? 'B' : 'A';
            seg[index] = 0;
            return;
        }

        int mid = (l + r) / 2;

        int left_child_index = 2 * index;
        int right_child_index = 2 * index + 1;

        if (pos <= mid) {
            update(left_child_index, l, mid, pos);
        } else {
            update(right_child_index, mid + 1, r, pos);
        }

        first[index] = first[left_child_index];
        last[index] = last[right_child_index];

        seg[index] = seg[left_child_index] + seg[right_child_index];
        if (last[left_child_index] == first[right_child_index]) {
            seg[index]++;
        }
    }

    void query(int index, int l, int r, int ql, int qr) {
        if (l > qr || r < ql) return;

        if (l >= ql && r <= qr) {

            if (!taken) {
                ans = seg[index];
                common_point = last[index];
                taken = true;
            } else {
                if (common_point == first[index]) {
                    ans++;
                }
                ans += seg[index];
                common_point = last[index];
            }
            return;
        }

        int mid = (l + r) / 2;

        int left_child_index = 2 * index;
        int right_child_index = 2 * index + 1;

        query(left_child_index, l, mid, ql, qr);
        query(right_child_index, mid + 1, r, ql, qr);
    }

    public int[] minDeletions(String s, int[][] queries) {
        n = s.length();

        seg = new int[4 * n];
        first = new char[4 * n];
        last = new char[4 * n];

        build(1, 0, n - 1, s.toCharArray());

        ArrayList<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                update(1, 0, n - 1, q[1]);
            } else {
                ans = 0;
                taken = false;
                query(1, 0, n - 1, q[1], q[2]);
                res.add(ans);
            }
        }

        int[] out = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}
