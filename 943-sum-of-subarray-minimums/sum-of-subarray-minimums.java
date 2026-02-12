import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] prev_min = new int[n];
        int[] next_min = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                prev_min[i] = -1;
            } else {
                prev_min[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                next_min[i] = n;
            } else {
                next_min[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;
        int MOD = 1000000007;

        for (int i = 0; i < n; i++) {

            long left = i - prev_min[i];
            long right = next_min[i] - i;

            long contri = (left * right) % MOD;

            ans = (ans + (arr[i] * contri) % MOD) % MOD;
        }

        return (int) ans;
    }
}
