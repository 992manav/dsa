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

        if (pos <= mid) {
            update(2 * index + 1, left_index, mid, pos);
        } else {
            update(2 * index + 2, mid + 1, right_index, pos);
        }

        segment_tree[index] = segment_tree[2 * index + 1] + segment_tree[2 * index + 2];
    }

    int query(int index, int q_left, int q_right, int left, int right) {
        if (q_left > right || q_right < left) {
            return 0; // no overlap
        }
        if (q_left <= left && right <= q_right) {
            return segment_tree[index]; // total overlap
        }

        int mid = (left + right) / 2;
        int leftCount = query(2 * index + 1, q_left, q_right, left, mid);
        int rightCount = query(2 * index + 2, q_left, q_right, mid + 1, right);

        return leftCount + rightCount;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        nums = new int[n];
        this.diff = diff;

        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }

        // Based on constraints:
        OFFSET = 30000;
        MAX_VAL = 60000;
        segment_tree = new int[4 * (MAX_VAL + 1)];
        Arrays.fill(segment_tree, 0);

        long count = 0;

        for (int j = 0; j < n; j++) {
            int qRight = nums[j] + diff + OFFSET;
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
