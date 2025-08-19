class Solution {

    int[] segment_tree;
    int[] arr;

    void build(int index, int left_limit, int right_limit) {

        if (left_limit == right_limit) {
            segment_tree[index] = arr[right_limit];
            return;
        }

        int mid = (left_limit + right_limit) / 2;

        int left_subtree_index = 2 * index + 1;
        int right_subtree_index = 2 * index + 2;

        build(left_subtree_index, left_limit, mid);
        build(right_subtree_index, mid + 1, right_limit);

        segment_tree[index] = Math.max(segment_tree[left_subtree_index], segment_tree[right_subtree_index]);
    }

    int query(int index, int left_limit, int right_limit,
              int target, int query_left_index_limit, int query_right_index_limit) {

        int root_val = segment_tree[index];

        if (root_val <= target) {
            return -1;
        }

        if (right_limit < query_left_index_limit || left_limit > query_right_index_limit) {
            return -1;
        }

        if (left_limit == right_limit) {
            return left_limit;   // ✅ return array index
        }

        int mid = (left_limit + right_limit) / 2;

        int left_subtree_index = 2 * index + 1;
        int right_subtree_index = 2 * index + 2;

        int ql = query(left_subtree_index, left_limit, mid, target, query_left_index_limit, query_right_index_limit);
        int qr = query(right_subtree_index, mid + 1, right_limit, target, query_left_index_limit, query_right_index_limit);

        if (ql == -1 && qr == -1) {
            return -1;   // ✅ FIXED: don’t return segment-tree index
        }

        if (ql != -1 && qr == -1) {
            return ql;
        }

        if (ql == -1 && qr != -1) {
            return qr;
        }

        return Math.min(ql, qr);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        this.arr = heights;
        this.segment_tree = new int[4 * heights.length];

        build(0, 0, heights.length - 1);

        int[] ans = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int h1 = heights[a];
            int h2 = heights[b];

            if (h2 > h1 || a == b) {
                ans[index] = b;
            } else {
                ans[index] = query(0, 0, heights.length - 1, Math.max(h1, h2), b + 1, heights.length - 1);
            }
            index++;
        }

        return ans;
    }
}
