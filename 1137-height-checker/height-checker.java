import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);

        int mismatch = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatch++;
            }
        }

        return mismatch;
    }
}
