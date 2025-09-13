import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1);

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            boolean fall = false;
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                fall = true;
                st.pop();
            }
            if (!st.isEmpty() && !fall) {
                nextGreater[i] = st.peek();
            }
            st.push(i);
        }

        int profit = 0;
        for (int i = 0; i < n; i++) {
            if (nextGreater[i] != -1) {
                profit += prices[nextGreater[i]] - prices[i];
            }
        }

        return profit;
    }
}
