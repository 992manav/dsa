import java.util.*;

class Solution {

    int calc_hash(String s){
        int hash = 0;
        int j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            int idx = c - 'a' + 1;
            hash = hash * 26 + idx;
            j++;
        }
        return hash;
    }

    public int longestValidSubstring(String word, List<String> f) {

        int n = word.length();

        int min = 11;
        int max = 0;

        Set<Integer> set = new HashSet<>();

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

            int hash = 0;
            int p = 1;

            for(int k = 0; k < len; k++){
                char c = word.charAt(k);
                int idx = c - 'a' + 1;
                hash = hash * 26 + idx;
                if(k < len - 1){
                    p = p * 26;
                }
            }

            int i = 0;
            int j = len - 1;

            if(set.contains(hash)){
                max_start[j] = Math.max(max_start[j], i);
            }

            while(j + 1 < n){
                hash = hash - (word.charAt(i) - 'a' + 1) * p;
                hash = hash * 26 + (word.charAt(j + 1) - 'a' + 1);
                i++;
                j++;
                if(set.contains(hash)){
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