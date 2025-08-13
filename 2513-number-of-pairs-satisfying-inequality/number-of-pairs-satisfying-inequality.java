import java.util.*;

class Solution {

    int[] segment_tree;
    int[] nums;
    int diff;
    int OFFSET;
    int MAX_VAL;

    void update(int index, int left_index, int right_index, int pos) {
        if (left_index == right_index) {
            segment_tree[index]++;
            return;
        }

        int mid = (left_index + right_index) / 2;

        int leftsubtree_index = 2 * index + 1;
        int rightsubtree_index = 2 * index + 2;

        if (pos <= mid) {
            update(leftsubtree_index, left_index, mid, pos);
        } else {
            update(rightsubtree_index, mid + 1, right_index, pos);
        }

        segment_tree[index] = segment_tree[leftsubtree_index] + segment_tree[rightsubtree_index];
    }

    void build_segment_tree() {
        Arrays.fill(segment_tree, 0);
    }

    int query(int index, int q_left_index, int q_right_index, int left_index, int right_index) {
        if (right_index < q_left_index || left_index > q_right_index) {
            return 0;
        }

        if (q_left_index <= left_index && right_index <= q_right_index) {
            return segment_tree[index];
        }

        int mid = (left_index + right_index) / 2;

        int leftsubtree_index = 2 * index + 1;
        int rightsubtree_index = 2 * index + 2;

        int countleft = query(leftsubtree_index, q_left_index, q_right_index, left_index, mid);
        int countright = query(rightsubtree_index, q_left_index, q_right_index, mid + 1, right_index);

        return countleft + countright;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        nums = new int[n];
        this.diff = diff;

        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }

        // Find dynamic OFFSET and MAX_VAL
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int val : nums) {
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val + diff);
            maxVal = Math.max(maxVal, val + diff);
        }

        OFFSET = -minVal; // shift so min becomes 0
        MAX_VAL = maxVal + OFFSET;

        segment_tree = new int[4 * (MAX_VAL + 1)];
        build_segment_tree();

        long count = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j] + diff;
            int qRight = val + OFFSET;
            if (qRight >= 0) {
                qRight = Math.min(qRight, MAX_VAL);
                count += query(0, 0, qRight, 0, MAX_VAL);
            }

            int pos = nums[j] + OFFSET;
            if (pos >= 0 && pos <= MAX_VAL) {
                update(0, 0, MAX_VAL, pos);
            }
        }

        return count;
    }
}
