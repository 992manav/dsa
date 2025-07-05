class Solution {

    // Heapify down within a limited heap size
    void heapifyDown(int[] nums, int i, int heapSize) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < heapSize && nums[left] > nums[largest]) {
                largest = left;
            }

            if (right < heapSize && nums[right] > nums[largest]) {
                largest = right;
            }

            if (largest == i) break;

            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;

            i = largest;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Build Max-Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i, n);
        }

       
        int heapSize = n;
        for (int j = 0; j < k - 1; j++) {
         
            int temp = nums[0];
            nums[0] = nums[heapSize - 1];
            nums[heapSize - 1] = temp;

            heapSize--; // reduce heap size
            heapifyDown(nums, 0, heapSize);
        }

       
        return nums[0];
    }
}
