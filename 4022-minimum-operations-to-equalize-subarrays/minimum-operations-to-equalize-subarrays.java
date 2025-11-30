import java.util.*;

// Ek single range query: [left, right] + original index
class Query implements Comparable<Query> {

    int left, right, idx;
    static int blockSize;

    Query(int l, int r, int i) {
        left = l;
        right = r;
        idx = i;
    }

    // Mo's algorithm ke hisab se sorting
    // Pehle left ko block me divide karke (sqrt decomposition)
    // Phir right ke hisab se
    public int compareTo(Query o) {
        int b1 = left / blockSize;   // mera left ka block
        int b2 = o.left / blockSize; // dusre ka left ka block

        // Agar dono different block me hai to block ke hisab se sort karo
        if (b1 != b2) return b1 - b2;

        // Agar same block me hai to right ke hisab se sort karo
        return right - o.right;
    }
}


// Mo's algorithm ka data structure jo window maintain karega
class MosAlgorithm {

    int[] arr;
    int k;

    // S1 = median ke left wala half (median included)
    // S2 = median ke right wala half
    // Yeh TreeMap sorted map hai, frequency store karta hai
    TreeMap<Integer, Integer> S1 = new TreeMap<>();
    TreeMap<Integer, Integer> S2 = new TreeMap<>();

    long sum1 = 0;   // S1 ka total sum
    long sum2 = 0;   // S2 ka total sum
    int count1 = 0;  // S1 me kitne elements hai
    int count2 = 0;  // S2 me kitne elements hai

    int L = 0;  // Mo window ka current left
    int R = -1; // Mo window ka current right (empty window)

    MosAlgorithm(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    // Mo's algorithm main processing: window ko query ke hisab se adjust karo
    public void processQueries(List<Query> queries, long[] ans) {
        for (Query q : queries) {

            // window ka left ko query.left tak laye
            while (L > q.left) {
                L--;
                add(L);
            }

            // window ka right ko query.right tak badhao
            while (R < q.right) {
                R++;
                add(R);
            }

            // left ko aage badhao (remove karte hue)
            while (L < q.left) {
                remove(L);
                L++;
            }

            // right ko peeche lao (remove karte hue)
            while (R > q.right) {
                remove(R);
                R--;
            }

            // ab current window ka answer compute karo
            ans[q.idx] = getAnswer();
        }
    }

    // Window me element add karna
    public void add(int idx) {
        int x = arr[idx];

        // Decide karna x S1 me jayega ya S2 me
        // Rule: S1 me hamesha median tak wale chhote elements rakhe jaate hain
        if (S1.isEmpty() || x <= S1.lastKey()) {

            // x median se chhota ya equal hai -> S1 me jayega
            addTo(S1, x);
            sum1 += x;
            count1++;
        }
        else {
            // x median se bada hai -> S2 me jayega
            addTo(S2, x);
            sum2 += x;
            count2++;
        }

        // S1 aur S2 ka size balance rakho taki median correct rahe
        balance();
    }

    // Window se element remove karna
    public void remove(int idx) {
        int x = arr[idx];

        // Agar x S1 me milta hai to S1 se remove
        if (S1.containsKey(x)) {
            removeFrom(S1, x);
            sum1 -= x;
            count1--;
        }
        else { // Otherwise definitely S2 me hai
            removeFrom(S2, x);
            sum2 -= x;
            count2--;
        }

        // S1 aur S2 ka size phir se balance karo
        balance();
    }

    // Map me x ki frequency +1
    void addTo(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    // Map me se x ki frequency -1 (agar 0 ho jaye to entry delete)
    void removeFrom(TreeMap<Integer, Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c - 1);
    }

    // MOST IMPORTANT: S1 aur S2 ka size relation maintain karna:
    //
    // S1 should have:
    //      count1 = count2  OR  count1 = count2 + 1
    //
    void balance() {

        // Agar S1 chhota ho S2 se => median S2 me chala gaya => fix karo
        while (count1 < count2) {
            int x = S2.firstKey();   // S2 ka smallest = median side ka element
            removeFrom(S2, x);
            sum2 -= x;
            count2--;

            addTo(S1, x);
            sum1 += x;
            count1++;
        }

        // Agar S1 me bahut zyada elements ho -> median S1 ke end me hoga
        while (count1 > count2 + 1) {
            int x = S1.lastKey();   // S1 ka largest = median ya median ke just left
            removeFrom(S1, x);
            sum1 -= x;
            count1--;

            addTo(S2, x);
            sum2 += x;
            count2++;
        }
    }

    // Answer nikalna:
    // Median = S1.lastKey()
    //
    // diff1 = sab left elements ko median tak lane ka cost
    // diff2 = sab right elements ko median tak lane ka cost
    //
    long getAnswer() {

        int median = S1.lastKey(); // S1 ka lastKey hi pure subarray ka median hota hai

        // Left ki total difference:
        // S1 wale elements chhote hote hai → (median - x)
        long diff1 = (long) median * count1 - sum1;

        // Right ki total difference:
        // S2 wale elements bade hote hai → (x - median)
        long diff2 = sum2 - (long) median * count2;

        // Har operation me +/- k kar sakte hai
        return (diff1 + diff2) / k;
    }
}


class Solution {

    public long[] minOperations(int[] nums, int k, int[][] queries) {

          int n = nums.length;
        int m = queries.length;

        // MOD K condition check (IMPORTANT)
        //
        // Rule:
        // Agar kisi range ke sare elements ka:
        //       nums[i] % k SAME nahi hai → equal banana IMPOSSIBLE
        //
        // because operation x -> x + k mod k ko change nahi karta
        //

        // GROUP array — sabse simple mod-equality checker
        // group[i] increases whenever nums[i] % k != nums[i-1] % k
        int[] group = new int[n];
        group[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % k == nums[i - 1] % k)
                group[i] = group[i - 1];       // same mod group
            else
                group[i] = group[i - 1] + 1;   // new mod group starts
        }

        long[] ans = new long[m];
        List<Query> list = new ArrayList<>();

        // Check per query if L..R lie in same mod group
        for (int i = 0; i < m; i++) {

            int L = queries[i][0];
            int R = queries[i][1];

            // If different group => mod breaks => impossible to equalize
            if (group[L] != group[R]) {
                ans[i] = -1;
            } 
            else {
                list.add(new Query(L, R, i));
            }
        }

        // Mo's algorithm ka block size
        Query.blockSize = 100;

        // Mo ordering
        Collections.sort(list);

        MosAlgorithm mos = new MosAlgorithm(nums, k);

        // Mo’s ke sorted queries process karo
        mos.processQueries(list, ans);

        return ans;
    }
}
