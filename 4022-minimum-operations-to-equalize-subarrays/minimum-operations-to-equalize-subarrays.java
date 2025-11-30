import java.util.*;

// Ek single range query store karva mate: [left, right] + original index
// Mo's algorithm ma queries ne sort karva use thay
class Query implements Comparable<Query> {

    int left, right, idx;
    static int blockSize;

    Query(int l, int r, int i) {
        left = l;
        right = r;
        idx = i;
    }

    // Mo's algorithm ni sorting logic:
    // Pela left ne blockSize thi divide kari block number male
    // Same block hoy to right ni value pr sort karvu
    public int compareTo(Query o) {
        int b1 = left / blockSize;    // aa query no left block
        int b2 = o.left / blockSize;  // biji query no left block

        if (b1 != b2) return b1 - b2; // juo, alag block hoy to block number pr sort

        return right - o.right;       // same block ma hoy to right ni value pr sort
    }
}


// Aa class Mo's algorithm nu main data structure maintain kare che
// Window ma elements add/remove kari sum, median, etc handle thay che
class MosAlgorithm {

    int[] arr;
    int k;

    // S1 = median walanu left half (median pan include)
    // S2 = median ni right side nu half
    // TreeMap ma sorted order + frequency store thay
    TreeMap<Integer, Integer> S1 = new TreeMap<>();
    TreeMap<Integer, Integer> S2 = new TreeMap<>();

    long sum1 = 0;  // S1 na total elements nu sum
    long sum2 = 0;  // S2 na total elements nu sum
    int count1 = 0; // S1 ma total count
    int count2 = 0; // S2 ma total count

    int L = 0;      // Mo window no current left pointer
    int R = -1;     // Mo window no current right pointer (start ma empty)

    MosAlgorithm(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    // Mo's algorithm — window ne query pr adjust karo ane answer compute karo
    public void processQueries(List<Query> queries, long[] ans) {
        for (Query q : queries) {

            // window no left ne target left sudhi laavo (value add karo)
            while (L > q.left) {
                L--;
                add(L);
            }

            // window no right target right sudhi move karo (add)
            while (R < q.right) {
                R++;
                add(R);
            }

            // left pointer ne aagal push karo (remove kari)
            while (L < q.left) {
                remove(L);
                L++;
            }

            // right pointer ne pachhal laavo (remove)
            while (R > q.right) {
                remove(R);
                R--;
            }

            // ahiya current window nu answer nikalvo
            ans[q.idx] = getAnswer();
        }
    }

    // Window ma element add karvo
    public void add(int idx) {
        int x = arr[idx];

        // Decide karvu ke x S1 ma jase ke S2 ma
        // Rule: S1 ma chhota elements + median hoy
        if (S1.isEmpty() || x <= S1.lastKey()) {
            // x median karta chhoto ke equal: S1 ma muki do
            addTo(S1, x);
            sum1 += x;
            count1++;
        }
        else {
            // x moto hoy to S2 ma jay
            addTo(S2, x);
            sum2 += x;
            count2++;
        }

        // S1 ane S2 ni size hamesha balanced rehvi joiye
        balance();
    }

    // Window ma thi element remove karvo
    public void remove(int idx) {
        int x = arr[idx];

        // Jo x S1 ma hase to S1 ma thi delete karo
        if (S1.containsKey(x)) {
            removeFrom(S1, x);
            sum1 -= x;
            count1--;
        }
        else {
            // Nahi to S2 ma j hase (karan ke S1 ma hoy to upar catch thai jase)
            removeFrom(S2, x);
            sum2 -= x;
            count2--;
        }

        // Remove pachi pan balance jaruri
        balance();
    }

    // Map ma x ni frequency +1 karva
    void addTo(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    // Map ma thi x ni frequency -1 karo (0 thay to remove)
    void removeFrom(TreeMap<Integer, Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c - 1);
    }

    // VERY VERY IMP: S1 ane S2 ne balance karvu
    //
    // Rule:
    //     S1 ni size = S2 ni size  OR S1 ni size = S2 + 1
    //
    void balance() {

        // Jo S1 ma elements ochha hoy (median S2 ma chali gayo) -> fix karo
        while (count1 < count2) {
            int x = S2.firstKey();  // S2 no smallest element
            removeFrom(S2, x);
            sum2 -= x;
            count2--;

            addTo(S1, x);
            sum1 += x;
            count1++;
        }

        // Jo S1 ma bahu extra elements hoy
        while (count1 > count2 + 1) {
            int x = S1.lastKey();   // S1 no last = median side no element
            removeFrom(S1, x);
            sum1 -= x;
            count1--;

            addTo(S2, x);
            sum2 += x;
            count2++;
        }
    }

    // Answer calculation:
    //
    // median = S1.lastKey()
    //
    // diff1 = S1 na elements ne median sudhi lana no cost
    // diff2 = S2 na elements ne median sudhi utaarva no cost
    //
    long getAnswer() {

        int median = S1.lastKey(); // S1 no lastKey j window no median

        // S1 ma badha x <= median: cost = (median - x)
        long diff1 = (long) median * count1 - sum1;

        // S2 ma badha x >= median: cost = (x - median)
        long diff2 = sum2 - (long) median * count2;

        // Ek operation ma ±k badlai sakay
        return (diff1 + diff2) / k;
    }
}


class Solution {

    public long[] minOperations(int[] nums, int k, int[][] queries) {

        int n = nums.length;
        int m = queries.length;

        // MOD K checker:
        //
        // Rule:
        //   Jo koi range L..R ma nums[i] % k same NATHI
        //   To tene equal banavu IMPOSSIBLE
        //
        // Karan: operation ma x -> x ± k karvathi mod k value same j rahe che
        //
        // group array thi consecutive same-mod segments banave
        int[] group = new int[n];
        group[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % k == nums[i - 1] % k)
                group[i] = group[i - 1];     // same mod group continue
            else
                group[i] = group[i - 1] + 1; // navo mod group start
        }

        long[] ans = new long[m];
        List<Query> list = new ArrayList<>();

        // Har query ma check karo ke L..R same mod group ma che ke nahi
        for (int i = 0; i < m; i++) {

            int L = queries[i][0];
            int R = queries[i][1];

            // Jo group mismatch -> mod equality broke -> impossible
            if (group[L] != group[R]) {
                ans[i] = -1;
            }
            else {
                list.add(new Query(L, R, i));
            }
        }

        // Mo's algorithm block size (static set)
        Query.blockSize = 100;

        // Queries ne Mo's algorithm ni order ma sort karo
        Collections.sort(list);

        MosAlgorithm mos = new MosAlgorithm(nums, k);

        // Sorted queries execute karo
        mos.processQueries(list, ans);

        return ans;
    }
}
