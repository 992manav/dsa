import java.util.*;

class Solution {
    public int minSwaps(int[] nums, int[] forb) {
        int n = nums.length;

        // map: jyare nums[i] == forb[i] hoy
        // aa value ketli vaar conflict create kare chhe eno count
        Map<Integer, Integer> map = new HashMap<>();

        // same = total number of conflicts
        int same = 0;

        // STEP 1:
        // conflicts count kariye
        for (int i = 0; i < n; i++) {
            if (nums[i] == forb[i]) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                same++;
            }
        }

        // CASE 1:
        // koi conflict nathi → already valid → 0 swaps
        if (same == 0) {
            return 0;
        }

        int total = 2 * n;

        // STEP 2:
        // banne array merge kariye
        int[] c = new int[total];
        System.arraycopy(nums, 0, c, 0, n);
        System.arraycopy(forb, 0, c, n, n);

        // sort kariye jethi frequency easily check thai
        Arrays.sort(c);

        /*
         STEP 3: IMPORTANT CHECK (KEM KARO CHHIYE?)

         IDEA:
         - Swaps thi pan ek limitation chhe
         - Jo koi ek number total/2 thi vadhare vaar aave
           to ene koi rite alag positions par muki j na sakai

         EXAMPLE:
         nums = [1, 1, 1]
         forb = [1, 2, 3]

         merged array c = [1,1,1,1,2,3]
         total = 6
         frequency of 1 = 4

         total/2 = 3
         4 > 3  → impossible

         KEM?
         - Swaps karo to pan
         - at least 2 positions par 1 saamne 1 j aavse
         - etle conflict unavoidable chhe

         General rule:
         👉 koi pan element jo total/2 thi vadhare hoy
            → arrangement possible nathi
            → answer = -1
        */

        int cnt = 1;
        for (int i = 1; i < total; i++) {
            if (c[i] == c[i - 1]) {
                cnt++;
            } else {
                // jyare navi value start thay
                // pichhli value ni frequency check kariye
                if (cnt > total / 2) {
                    return -1;
                }
                cnt = 1;
            }
        }

        // last value mate pan check
        if (cnt > total / 2) {
            return -1;
        }


        // 10 10
        // aaaaabcdef a 
        // ghijkaaaaa a 
        
        // bbbccaaaaad 
        // aaaaabbbccd

        
        /*
         STEP 4: Minimum swaps calculation

         1 swap maximum 2 conflicts solve kare chhe
         etle base swaps = (same + 1) / 2

         pan…
         jo koi ek value ghani vaar conflict kare
         (example: value 5 → 4 conflicts)

         to minimum swaps at least 4 j lagse
         etle max leva pade:
         max( (same+1)/2 , max conflict frequency )
        */

        int swaps = (same + 1) / 2;

        for (int count : map.values()) {
            if (count > swaps) {
                swaps = count;
            }
        }

        return swaps;
    }
}
