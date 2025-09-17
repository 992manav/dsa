import java.util.*;

class FoodRatings {
    HashMap<String, TreeMap<Integer, TreeSet<String>>> map = new HashMap<>();
    HashMap<String, String> cu_f_map = new HashMap<>();
    HashMap<String, Integer> f_r_map = new HashMap<>();
    int n;

    public void insert(String f, String c, int r) {
        map.computeIfAbsent(c, k -> new TreeMap<>())
           .computeIfAbsent(r, k -> new TreeSet<>())
           .add(f);
    }

    public FoodRatings(String[] foods, String[] cus, int[] rat) {
        n = foods.length;
        for (int i = 0; i < n; i++) {
            cu_f_map.put(foods[i], cus[i]);
            f_r_map.put(foods[i], rat[i]);
            insert(foods[i], cus[i], rat[i]);
        }
    }

    public void changeRating(String f, int nr) {
        String c = cu_f_map.get(f);
        int oldR = f_r_map.get(f);

        TreeSet<String> set = map.get(c).get(oldR);
        set.remove(f);
        if (set.isEmpty()) map.get(c).remove(oldR);

        insert(f, c, nr);
        f_r_map.put(f, nr);
    }

    public String highestRated(String c) {
        Map.Entry<Integer, TreeSet<String>> entry = map.get(c).lastEntry();
        return entry.getValue().first();
    }
}
