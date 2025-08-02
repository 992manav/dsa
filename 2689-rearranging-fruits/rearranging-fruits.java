import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int xor = 0;
        int minElem = Integer.MAX_VALUE;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : basket1) {
            xor ^= num;
            minElem=Math.min(minElem, num);
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : basket2) {
            xor ^= num;
            minElem=Math.min(minElem, num);
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        if (xor != 0) return -1;

        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();


        for (int key : map1.keySet()) {
            int count1 = map1.get(key);
            int count2 = map2.getOrDefault(key, 0);

            if(count1+count2==1){
                return -1;
            }

            if (count1 > count2) {
                for (int i = 0; i < (count1 - count2) / 2; i++) {
                    lst1.add(key);
                }
            }
        }

     
        for (int key : map2.keySet()) {
            int count2 = map2.get(key);
            int count1 = map1.getOrDefault(key, 0);

             if(count1+count2==1){
                return -1;
            }
            
            if (count2 > count1) {
                for (int i = 0; i < (count2 - count1) / 2; i++) {
                    lst2.add(key);
                }
            }
        }

  
        Collections.sort(lst1);
        Collections.sort(lst2, Collections.reverseOrder());

        long cost = 0;
        for (int i = 0; i < lst1.size(); i++) {
            int a = lst1.get(i);
            int b = lst2.get(i);
            cost += Math.min(Math.min(a, b), 2 * minElem);
        }

        return cost;
    }
}
