import java.util.*;

class Solution {
    public int[] subarrayMajority(int[] nums, int[][] queries) {
        List<Query> list = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            list.add(new Query(queries[i][0], queries[i][1], i, queries[i][2]));
        }

        MosAlgorithm mos = new MosAlgorithm(nums);
        mos.sortQuery(list);
        return mos.processQueries(list);
    }
}

class MosAlgorithm {
    int[] arr;
    int n;
    int blockSize;
    int currL = 0, currR = -1;

    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    int max = 0;

    public MosAlgorithm(int[] arr) {
        this.arr = arr;
        this.n = arr.length;

        this.blockSize = Math.max(1, (int) Math.sqrt(n)); 
        Query.blockSize = this.blockSize;
    }

    public void sortQuery(List<Query> queries) {
        Collections.sort(queries);
    }

    public int[] processQueries(List<Query> queries) {
        currL = 0;
        currR = -1;
        int[] ans = new int[queries.size()];

        for(Query q : queries) {
            while(currL > q.left) {
                currL--;
                add(currL);
            }
            while(currR < q.right) {
                currR++;
                add(currR);
            }
            while(currL < q.left) {
                remove(currL);
                currL++;
            }
            while(currR > q.right) {
                remove(currR);
                currR--;
            }
            ans[q.idx] = getAnswer(q.threshold);
        }
        return ans;
    }

    public void add(int idx) {
        int val = arr[idx];
        int f = freq.getOrDefault(val, 0);

        if (f != 0) {
            map.get(f).remove(val);
        }

        freq.put(val, f + 1);

        if (!map.containsKey(f + 1)) {
            map.put(f + 1, new TreeSet<>());
        }
        map.get(f + 1).add(val);

        if (f + 1 > max) {
            max = f + 1;
        }
    }

    public void remove(int idx) {
        int val = arr[idx];
        int f = freq.get(val);

        map.get(f).remove(val);
        freq.remove(val);

        if (f != 1) {
            freq.put(val, f - 1);
            map.get(f - 1).add(val);
        }

        while(max > 0 && map.get(max).isEmpty()) {
            max--;
        }
    }

    public int getAnswer(int threshold) {
        if (threshold > max) return -1;
        return map.get(max).first();
    }
}

class Query implements Comparable<Query> {
    int left, right, idx, threshold;
    static int blockSize;

    Query(int l, int r, int i, int t) {
        left = l;
        right = r;
        idx = i;
        threshold = t;
    }

    @Override
    public int compareTo(Query other) {
        int block1 = this.left / blockSize;
        int block2 = other.left / blockSize;

        if (block1 != block2) {
            return Integer.compare(block1, block2);
        }

        if (block1 % 2 == 1) {
            return Integer.compare(this.right, other.right);
        }

        return Integer.compare(other.right, this.right);
    }
}
