import java.util.Arrays;
import java.util.Stack;

class Solution {

    static final int MOD = (int)1e9 + 7;

    void fun_left(int[] left, int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
    }

    void fun_right(int[] right, int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? arr.length - 1 : st.peek() - 1;
            st.push(i);
        }
    }

    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        fun_left(left, arr);
        fun_right(right, arr);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long leftCount = i - left[i] + 1;
            long rightCount = right[i] - i + 1;
            long contribution = (arr[i] % MOD * leftCount % MOD * rightCount % MOD) % MOD;
            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }
}
