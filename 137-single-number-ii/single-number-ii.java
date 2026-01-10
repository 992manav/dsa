class Solution {
    public int singleNumber(int[] nums) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 32; i++) {

            int count1 = 0;

            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    count1++;
                }
            }

            if (count1 % 3 != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        sb.reverse();

        // handle signed integer
        if (sb.charAt(0) == '0') {
            return Integer.parseInt(sb.toString(), 2);
        }

        // negative number (two's complement)
        long val = Long.parseLong(sb.toString(), 2);
        return (int)(val - (1L << 32));
    }
}
