class Solution {

    String s;

    long fun(int length) {
        // int first = s.charAt(0) - '0';
        // first--;

        // long count = first * (long) Math.pow(9, length - 1);
        long count=0;
        for (int i = 0; i < length; i++) {
            int d = s.charAt(i) - '0';
            if(d==0){
                break;
            }

            if (i == length - 1) {
                count += d;
            } else {
                count += (d - 1) * (long) Math.pow(9, length - i - 1);
            }
        }

        return count;
    }

    public long countDistinct(long x) {
        s = Long.toString(x);
        int n = s.length();
        long ans = 0;

        for (int len = 1; len <= n; len++) {
            if (len < n) {
                long pow = (long) Math.pow(9, len);
                ans += pow;
            } else {
                long res = fun(len);
                ans += res;
            }
        }

        return ans;
    }
}
