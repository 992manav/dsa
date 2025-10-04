class Solution {

    public int find_leftmost(int[] height, int idx) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[idx]) {
                return i;
            }
        }
        return -1;
    }

    public int find_rightmost(int[] height, int idx) {
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= height[idx]) {
                return i;
            }
        }
        return -1;
    }

    public int maxArea(int[] height) {
        // har danda uske leftmost aur rightmost usse bada danda dhundhega 
        int max_area = 0;

        for (int i = 0; i < height.length; i++) {
            int left = find_leftmost(height, i);
            int right = find_rightmost(height, i);

            if (left != -1) {  // avoid invalid area
                int area = (i - left) * height[i];
                max_area = Math.max(area, max_area);
            }

            if (right != -1) {  // avoid invalid area
                int area = (right - i) * height[i];
                max_area = Math.max(area, max_area);
            }
        }

        return max_area;
    }
}
