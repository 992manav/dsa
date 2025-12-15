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

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for(int i = 0; i < arr.length; i++){
            int bits = fun(arr[i]);

            if(map.containsKey(bits)){
                map.get(bits).add(arr[i]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(bits, list);
            }
        }

        int idx = 0;
        for(ArrayList<Integer> list : map.values()){
            Collections.sort(list);
            for(int x : list){
                arr[idx++] = x;
            }
        }

        return arr;
    }
}
