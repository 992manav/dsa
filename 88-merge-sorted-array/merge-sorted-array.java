import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] a = new int[m + n];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                a[index] = nums1[i];
                i++;
            } else {
                a[index] = nums2[j];
                j++;
            }
            index++; 
        }

      
        while (i < m) {
            a[index++] = nums1[i++];
        }
        while (j < n) {
            a[index++] = nums2[j++];
        }

        for (int k = 0; k < a.length; k++) { 
            nums1[k] = a[k];
        }
    }
}
