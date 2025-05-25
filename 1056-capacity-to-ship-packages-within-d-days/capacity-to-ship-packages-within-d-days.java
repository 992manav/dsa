class Solution {

   

    // Find the maximum value and total sum of the array
    public static int[] find_max(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int ele : arr) {
            if (ele > max) {
                max = ele; // update max
            }
            sum = sum + ele; // calculate total sum
        }
        return new int[]{max, sum}; // return both as an array
    }

    // Check if it's possible to ship within given days using max 'weight'
    public static boolean check(int[] arr, int weight, int days) {
        int sum = 0;
        int day = 1; // start from day 1

        for (int num : arr) {
            if (sum + num > weight) {
                day++; // need one more day
                sum = 0;
            }
            sum += num; // add current weight

            if (day > days) {
                return false; // can't ship in given days
            }
        }

        return true; // shipping possible in given days
    }

    // Binary search to find minimum possible max weight
    public static int binary_search(int[] w, int days) {
        int[] arr = find_max(w);
        int low = arr[0]; // minimum capacity (at least max item)
        int high = arr[1]; // maximum capacity (sum of all)
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; // try middle capacity

            if (check(w, mid, days)) {
                ans = mid; // possible answer
                high = mid - 1; // try for smaller capacity
            } else {
                low = mid + 1; // need more capacity
            }
        }

        return ans;
    }

    // Main function to call from outside
    public static int shipWithinDays(int[] w, int days) {
        return binary_search(w, days);
    }
}
