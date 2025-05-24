class Solution {
    public void nextPermutation(int[] nums) {

        if (nums.length == 2) {
            swap(nums, nums.length - 1, nums.length - 2);
        }

        if (nums.length >= 3) {

            if (nums[nums.length - 1] > nums[nums.length - 2]) {  //secondlast<last
               
                swap(nums, nums.length - 1, nums.length - 2);
            
            } 
            
            
        else {
                //secondlast>last

                if (nums[nums.length - 3] < nums[nums.length - 2] && nums[nums.length - 3] >= nums[nums.length - 1]) {  //third is between
                    swap(nums, nums.length - 2, nums.length - 3);  //swap with max
                    swap(nums, nums.length - 2, nums.length - 1);
                } else if(nums[nums.length - 3] < nums[nums.length - 1]) {
                    swap(nums, nums.length - 1, nums.length - 3);  //swap with just bigger
                    swap(nums, nums.length - 2, nums.length - 1);
                }
                else{
                        int i = nums.length - 3;
                        while (i >= 0 && nums[i] >= nums[i + 1]) {
                            i--;
                        }

                        if (i ==-1 && nums[0] >= nums[1]) {
                            reverse(nums, 0, nums.length - 1);
                        }
                        else {
                            int j;
                            if (i>=0 && nums[i] < nums[i + 1]) {
                                for (j = i + 1; j < nums.length; j++) {
                                    if (nums[j] <= nums[i]) {     //find just bigger number
                                        break;
                                    }
                                }

                                swap(nums, i, j - 1);
                                reverse(nums, i + 1, nums.length - 1);
                            }
                        }
                    }
            }
        }
    }

    public void reverse(int[] arr, int left, int right) {

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
