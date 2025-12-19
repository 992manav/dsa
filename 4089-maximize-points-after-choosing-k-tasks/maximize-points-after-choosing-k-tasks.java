class Solution {
    public long maxPoints(int[] tec1, int[] tec2, int k) {

        int n = tec1.length;
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int key = tec2[i] - tec1[i];

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }

        long points = 0;

        for (Integer key : map.keySet()) {
            List<Integer> lst = map.get(key);

            for (int idx = 0; idx < lst.size(); idx++) {
                int i = lst.get(idx);

                if (key < 0) {
                    points += tec1[i];
                    k--;
                } else {
                    if (k > 0) {
                        points += tec1[i];
                        k--;
                    } else {
                        points += tec2[i];
                    }
                }
            }
        }

        return points;
    }
}
