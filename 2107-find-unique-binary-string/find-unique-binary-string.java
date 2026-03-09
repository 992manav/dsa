class Solution {
    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        int[] arr = new int[1 << n];

        char[] or = nums[0].toCharArray();

        for(int i = 0; i < n; i++){
            String s = nums[i];

            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    or[j] = '1';
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < or.length; i++){
            if(or[i] == '1'){
                sb.append('0');
            }else{
                sb.append('1');
            }
        }

        String str = sb.toString();

        for(int i = 0; i < n; i++){
            if(nums[i].equals(str)){

                for(int j = 0; j < n; j++){
                    arr[Integer.parseInt(nums[j], 2)] = 1;
                }

                for(int j = 0; j < (1 << n); j++){
                    if(arr[j] == 0){
                        String s = Integer.toBinaryString(j);

                        while(s.length() < n){
                            s = "0" + s;
                        }

                        return s;
                    }
                }

                return "";
            }
        }

        return str;
    }
}