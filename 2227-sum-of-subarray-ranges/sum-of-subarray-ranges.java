import java.util.Stack;

class Solution {

    // Removed MOD constant since we want the full answer.
    void fun_left(int[] left_min, int[] left_max, int[] arr) {
        Stack<Integer> st = new Stack<>();

        // For minimum contributions
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            left_min[i] = st.isEmpty() ? -1 : st.peek();  // previous smaller index
            st.push(i);
        }

        st.clear();

        // For maximum contributions
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            left_max[i] = st.isEmpty() ? -1 : st.peek();  // previous greater index
            st.push(i);
        }
    }

    void fun_right(int[] right_min, int[] right_max, int[] arr) {
        Stack<Integer> st = new Stack<>();

        // For minimum contributions
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right_min[i] = st.isEmpty() ? arr.length : st.peek();  // next smaller index
            st.push(i);
        }

        st.clear();

        // For maximum contributions
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            right_max[i] = st.isEmpty() ? arr.length : st.peek();  // next greater index
            st.push(i);
        }
    }

    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int[] left_min = new int[n];
        int[] right_min = new int[n];
        int[] left_max = new int[n];
        int[] right_max = new int[n];

        fun_left(left_min, left_max, arr);
        fun_right(right_min, right_max, arr);

        long sum_min = 0;
        long sum_max = 0;

        for (int i = 0; i < n; i++) {
            // For arr[i] as minimum:
            // Count of subarrays where arr[i] is the minimum is:
            //   (i - left_min[i]) * (right_min[i] - i)
            long count_min = (i - left_min[i]) * (right_min[i] - i);
            sum_min += arr[i] * count_min;

            // For arr[i] as maximum:
            // Count of subarrays where arr[i] is the maximum is:
            //   (i - left_max[i]) * (right_max[i] - i)
            long count_max = (i - left_max[i]) * (right_max[i] - i);
            sum_max += arr[i] * count_max;
        }

        // The final answer is the difference of the sums.
        return sum_max - sum_min;
    }
}
