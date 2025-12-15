class Solution {
    int fun(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((pehla, dusra) -> {
            int bitCountA = fun(pehla);
            int bitCountB = fun(dusra);

            if (bitCountA == bitCountB) {
                return pehla - dusra;
            }
            return bitCountA - bitCountB;
        });

        for (int num : arr) {
            pq.add(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.poll();
        }

        return arr;
    }
}
