class Solution {
    public void nextPermutation(int[] nums) {

        // Case when array has only 2 elements: just swap them
        if (nums.length == 2) {
            swap(nums, nums.length - 1, nums.length - 2);
        }

        // If array has 3 or more elements
        if (nums.length >= 3) {

            // Case when the last element is greater than the second last
            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                // Swap them to get the next permutation
                swap(nums, nums.length - 1, nums.length - 2);
            } 
            else {
                // More complex case where last element is not greater than second last

                // Check if third last is between second last and last
                if (nums[nums.length - 3] < nums[nums.length - 2] && nums[nums.length - 3] >= nums[nums.length - 1]) {
                    // Swap third last and second last
                    swap(nums, nums.length - 2, nums.length - 3);
                    // Swap the new second last with last
                    swap(nums, nums.length - 2, nums.length - 1);
                } 
                // Check if third last is less than last
                else if(nums[nums.length - 3] < nums[nums.length - 1]) {
                    // Swap third last with last (next bigger number)
                    swap(nums, nums.length - 1, nums.length - 3);
                    // Swap last two to adjust
                    swap(nums, nums.length - 2, nums.length - 1);
                }
                else {
                    // General case: find the first decreasing element from the end
                    int i = nums.length - 3;
                    while (i >= 0 && nums[i] >= nums[i + 1]) {
                        i--;
                    }

                    // If the whole array is non-increasing, reverse it
                    if (i == -1 && nums[0] >= nums[1]) {
                        reverse(nums, 0, nums.length - 1);
                    }
                    else {
                        // Find the next bigger number than nums[i] from the end
                        int j;
                        if (i >= 0 && nums[i] < nums[i + 1]) {
                            for (j = i + 1; j < nums.length; j++) {
                                if (nums[j] <= nums[i]) {
                                    break;
                                }
                            }

                            // Swap nums[i] with just bigger number found
                            swap(nums, i, j - 1);
                            // Reverse the suffix to get the smallest next permutation
                            reverse(nums, i + 1, nums.length - 1);
                        }
                    }
                }
            }
        }
    }

    // Helper function to reverse array between two indices
    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Helper function to swap two elements in array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
