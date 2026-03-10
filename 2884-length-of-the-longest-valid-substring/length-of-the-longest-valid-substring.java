import java.util.*;

class Solution {

    int calc_hash(String s){
        int hash = 0;
        int j = 0;
        int len = s.length();

        while(j < len){
            int idx = s.charAt(j) - 'a' + 1;
            hash = hash * 26 + idx;
            j++;
        }
        return hash;
    }

    public int longestValidSubstring(String word, List<String> f) {

        int n = word.length();
        char[] arr = word.toCharArray();

        int min = 11;
        int max = 0;

        Set<Integer>[] sets = new HashSet[11];

        for(int i = 0; i <= 10; i++){
            sets[i] = new HashSet<>();
        }

        for(int i = 0; i < f.size(); i++){
            String s = f.get(i);
            int len = s.length();

            if(len > max) max = len;
            if(len < min) min = len;

            sets[len].add(calc_hash(s));
        }

        int[] max_start = new int[n];
        Arrays.fill(max_start, -1);

        int[] pow = new int[max + 1];
        pow[0] = 1;

        for(int i = 1; i <= max; i++){
            pow[i] = pow[i - 1] * 26;
        }

        for(int len = min; len <= max; len++){

            if(len > n) break;

            if(sets[len].isEmpty()){
                continue;
            }

            int hash = 0;

            for(int k = 0; k < len; k++){
                hash = hash * 26 + (arr[k] - 'a' + 1);
            }

            int i = 0;
            int j = len - 1;

            if(sets[len].contains(hash)){
                if(max_start[j] < i){
                    max_start[j] = i;
                }
            }

            while(j + 1 < n){

                hash = hash - (arr[i] - 'a' + 1) * pow[len - 1];
                hash = hash * 26 + (arr[j + 1] - 'a' + 1);

                i++;
                j++;

                if(sets[len].contains(hash)){
                    if(max_start[j] < i){
                        max_start[j] = i;
                    }
                }
            }
        }

        int ans = 0;
        int left = 0;

        for(int r = 0; r < n; r++){

            if(max_start[r] != -1){
                int val = max_start[r] + 1;
                if(val > left){
                    left = val;
                }
            }

            int len = r - left + 1;
            if(len > ans){
                ans = len;
            }
        }

        return ans;
    }
}