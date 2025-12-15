class Solution {
    public int[] sortByBits(int[] nums) {

        // int[] par comparator directly kaam nahi karta
        // isliye Integer[] banate hain
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (first, second) -> {

            // first aur second ke binary me kitne 1s hain
            int firstBits = Integer.bitCount(first);
            int secondBits = Integer.bitCount(second);

            if (firstBits == secondBits) {
                return first - second;
            } else {
                return firstBits - secondBits;
            }
        });

        // wapas Integer[] se int[] me copy
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}
