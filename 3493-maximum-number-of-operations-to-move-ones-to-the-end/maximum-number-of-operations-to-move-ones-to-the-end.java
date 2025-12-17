class Solution {
    public int maxOperations(String s) {
        int no_op = 0;
        int count = 0;

        int len=s.length();
        for (int i = 0; i < len - 1; i++) {
            char c = s.charAt(i);

            if (c == '1') {
                count++;
            } else {
                if (s.charAt(i + 1) == '1') {
                    no_op += count;
                }
            }
        }

        if(s.charAt(len-1)=='0'){
            no_op += count;
        }
        return no_op;
    }
}
