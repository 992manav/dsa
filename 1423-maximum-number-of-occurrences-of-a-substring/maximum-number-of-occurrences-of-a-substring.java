class Solution {
    public int maxFreq(String s, int k, int min, int max) {

        int i = 0;
        int j = 0;

        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int n = s.length();

        Map<String,Integer> freqmap = new HashMap<>();

        while(j < n){

            char d = s.charAt(j);
            map.put(d, map.getOrDefault(d,0) + 1);

            while(map.size() > k){

                char c = s.charAt(i);
                map.put(c, map.get(c) - 1);

                if(map.get(c) == 0){
                    map.remove(c);
                }

                i++;
            }

            int len = j - i + 1;

            if(len >= min){
                String str = s.substring(j - min + 1, j + 1);
                freqmap.put(str, freqmap.getOrDefault(str,0) + 1);
            }

            j++;
        }

        for(Integer val : freqmap.values()){
            ans = Math.max(ans, val);
        }

        return ans;
    }
}