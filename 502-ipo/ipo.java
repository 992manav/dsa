class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // jtlu w 6 ena thi sodho ke capital array ma je je w thi nano 6
        // eno profit ni value jeni maximum hoy ene 

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < profits.length; i++) {
            map.computeIfAbsent(profits[i], key -> new ArrayList<>()).add(capital[i]);
        }

        while (k > 0) {

            boolean found = false;
            for (Integer key : map.descendingKeySet()) {
               
                List<Integer> lst = map.get(key);
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i) <= w) {
                        w += key;
                        lst.remove(i);
                        found = true;
                        break;
                    }
                }
                if (found) {
                     k--;
                    break;
                }
            }
            if(!found){
                break;
            }
        }

        return w;
    }
}
