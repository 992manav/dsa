class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        int[] arr = new int[1 << n];

        for(int i = 0; i < n; i++){
            arr[Integer.parseInt(nums[i], 2)] = 1;
        }

        for(int i = 0; i < (1 << n); i++){
            if(arr[i] == 0){
                String s = Integer.toBinaryString(i);

                while(s.length() < n){
                    s = "0" + s;
                }

                return s;
            }
        }

        return "";
    }
}