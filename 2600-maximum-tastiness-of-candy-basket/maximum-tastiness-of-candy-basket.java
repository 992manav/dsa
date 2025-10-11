import java.util.*;

class Solution {

    boolean check_possible(int min_distance, int[] price, int k) {
        int count = 1;
        int last = price[0];
        for (int i = 1; i < price.length; i++) {
            int dist = price[i] - last;
            if (dist >= min_distance) {
                count++;
                last = price[i];
            }
        }

        if (count >= k) {
            return true;
        }

        return false;
    }

    int bs(int low, int high, int[] price, int k) {
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (check_possible(mid, price, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int max_distance = price[price.length - 1] - price[0];
        int min_distance = 0;
        return bs(min_distance, max_distance, price, k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] price = {1, 2, 5, 8, 13, 21};
        int k = 3;
        System.out.println(s.maximumTastiness(price, k)); // Example output
    }
}
