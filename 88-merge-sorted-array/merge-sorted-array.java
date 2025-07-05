import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = n - 1; i >= 0; i--) {
            nums1[m + i] = nums2[i];
        }

        int gap = (m + n) / 2;
        int i, j;

        while (gap > 0) { 

            i = 0;
            j = i + gap;

            while (j < m + n) {

                if (nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }

                i++;
                j++;
            }

            if (gap == 1)
                gap = 0;
            else
                gap = (gap + 1) / 2; 
        }
    }
}
