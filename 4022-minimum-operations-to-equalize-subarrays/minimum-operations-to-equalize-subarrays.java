import java.util.*;

class Query implements Comparable<Query> {

    int left, right, idx;
    static int blockSize;

    Query(int l, int r, int i) {
        left = l;
        right = r;
        idx = i;
    }

    public int compareTo(Query o) {
        int b1 = left / blockSize;
        int b2 = o.left / blockSize;
        if (b1 != b2) return b1 - b2;
        return right - o.right;
    }
}


class MosAlgorithm {

    int[] arr;
    int k;

    TreeMap<Integer, Integer> S1 = new TreeMap<>();
    TreeMap<Integer, Integer> S2 = new TreeMap<>();

    long sum1 = 0;
    long sum2 = 0;
    int count1 = 0;  // Total count of elements in S1
    int count2 = 0;  // Total count of elements in S2

    int L = 0;
    int R = -1;

    MosAlgorithm(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public void processQueries(List<Query> queries, long[] ans) {
        for (Query q : queries) {

            while (L > q.left) { L--; add(L); }
            while (R < q.right) { R++; add(R); }
            while (L < q.left) { remove(L); L++; }
            while (R > q.right) { remove(R); R--; }

            ans[q.idx] = getAnswer();
        }
    }

    public void add(int idx) {
        int x = arr[idx];

        if (S1.isEmpty() || x <= S1.lastKey()) {
            addTo(S1, x);
            sum1 += x;
            count1++;
        } else {
            addTo(S2, x);
            sum2 += x;
            count2++;
        }

        balance();
    }

    public void remove(int idx) {
        int x = arr[idx];

        if (S1.containsKey(x)) {
            removeFrom(S1, x);
            sum1 -= x;
            count1--;
        } else {
            removeFrom(S2, x);
            sum2 -= x;
            count2--;
        }

        balance();
    }

    void addTo(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    void removeFrom(TreeMap<Integer, Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c - 1);
    }

    void balance() {

        while (count1 < count2) {
            int x = S2.firstKey();
            removeFrom(S2, x);
            sum2 -= x;
            count2--;
            addTo(S1, x);
            sum1 += x;
            count1++;
        }

        while (count1 > count2 + 1) {
            int x = S1.lastKey();
            removeFrom(S1, x);
            sum1 -= x;
            count1--;
            addTo(S2, x);
            sum2 += x;
            count2++;
        }
    }

    long getAnswer() {

        int median = S1.lastKey();

        long diff1 = (long) median * count1 - sum1;
        long diff2 = sum2 - (long) median * count2;

        return (diff1 + diff2) / k;
    }
}


class Solution {

    public long[] minOperations(int[] nums, int k, int[][] queries) {

        int n = nums.length;
        int m = queries.length;

        long[] last = new long[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] % k == nums[i - 1] % k) last[i] = last[i - 1];
            else last[i] = i;
        }

        long[] ans = new long[m];
        List<Query> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            if (last[R] > L) {
                ans[i] = -1;
            } else {
                list.add(new Query(L, R, i));
            }
        }

        Query.blockSize = 100;
        Collections.sort(list);

        MosAlgorithm mos = new MosAlgorithm(nums, k);
        mos.processQueries(list, ans);

        return ans;
    }
}


