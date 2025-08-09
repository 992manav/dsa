import java.util.*;

class Pair {
    int num;
    int idx;

    Pair(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
        }
        List<Pair> lst = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            lst.add(pq.poll());
        }
        Collections.sort(lst, (a, b) -> a.idx - b.idx);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = lst.get(i).num;
        }
        return res;
    }
}
