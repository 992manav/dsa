class Solution {

    boolean check(int[] arr, int mid, int m, int k) {
        int count = 0;  // Count of consecutive bloomable flowers
        int days = 0;   // Count of bouquets made

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid) {
                count++;
                if (count == k) {
                    days++;
                    count = 0;
                    if (days == m) break; // Early exit if we already have enough bouquets
                }
            } else {
                count = 0;
                // \U0001f525 Early break: If remaining flowers < required, break early
                if (arr.length - i < (m - days) * k)
                    break;
            }
        }

        return days >= m;
    }


    int binary_search(int[] arr,int m,int k){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int val : arr) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(arr, mid, m, k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int minDays(int[] arr, int m, int k) {
        if ((long)m * (long)k > arr.length) return -1;
        return binary_search(arr, m, k);
    }
}
