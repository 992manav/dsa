import java.util.*;

class Solution {

    private static final long MOD1 = 1_000_000_007L, BASE1 = 31L;
    private static final long MOD2 = 998_244_353L,   BASE2 = 37L;

    long calc_hash(String s){
        long h1 = 0, h2 = 0;
        for(char c : s.toCharArray()){
            int idx = c - 'a' + 1;
            h1 = (h1 * BASE1 + idx) % MOD1;
            h2 = (h2 * BASE2 + idx) % MOD2;
        }
        return h1 * MOD2 + h2;
    }

    public int longestValidSubstring(String word, List<String> f) {

        int n = word.length();

        int min = 11;
        int max = 0;

        Set<Long> set = new HashSet<>();

        for(int i = 0; i < f.size(); i++){
            String s = f.get(i);
            int len = s.length();

            if(len > max) max = len;
            if(len < min) min = len;

            set.add(calc_hash(s));
        }

        int[] max_start = new int[n];
        Arrays.fill(max_start, -1);

        for(int len = min; len <= max; len++){

            if(len > n) break;

            long h1 = 0, h2 = 0;
            long p1 = 1, p2 = 1;

            for(int k = 0; k < len - 1; k++){
                p1 = p1 * BASE1 % MOD1;
                p2 = p2 * BASE2 % MOD2;
            }

            for(int k = 0; k < len; k++){
                int idx = word.charAt(k) - 'a' + 1;
                h1 = (h1 * BASE1 + idx) % MOD1;
                h2 = (h2 * BASE2 + idx) % MOD2;
            }

            int i = 0;
            int j = len - 1;

            if(set.contains(h1 * MOD2 + h2)){
                max_start[j] = Math.max(max_start[j], i);
            }

            while(j + 1 < n){

                long rem1 = (word.charAt(i) - 'a' + 1) * p1 % MOD1;
                long rem2 = (word.charAt(i) - 'a' + 1) * p2 % MOD2;

                j++;
                int idx = word.charAt(j) - 'a' + 1;

                h1 = ((h1 - rem1) * BASE1 + idx) % MOD1;
                if(h1 < 0) h1 += MOD1;

                h2 = ((h2 - rem2) * BASE2 + idx) % MOD2;
                if(h2 < 0) h2 += MOD2;

                i++;

                if(set.contains(h1 * MOD2 + h2)){
                    max_start[j] = Math.max(max_start[j], i);
                }
            }
        }

        int ans = 0;
        int left = 0;

        for(int r = 0; r < n; r++){
            if(max_start[r] != -1){
                left = Math.max(left, max_start[r] + 1);
            }
            ans = Math.max(ans, r - left + 1);
        }

        return ans;
    }
}