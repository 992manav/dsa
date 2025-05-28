class Solution {

    int calc(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value > 0) { // Only consider non-zero frequencies
                if (value < min) min = value;
                if (value > max) max = value;
            }
        }

        return max - min;
    }

    public int beautySum(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] arr = new int[26]; // Frequency array

            for (int j = i; j < s.length(); j++) {
                int k = s.charAt(j) - 'a';
                arr[k]++;

                int ans = calc(arr);
                sum += ans;
            }
        }

        return sum;
    }
}
