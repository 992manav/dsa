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
            String f = foods[i];
            String c = cus[i];
            int r = rat[i];
            cu_f_map.put(f, c);
            f_r_map.put(f, r);
            insert(f, c, r);
        }
    }

    public void changeRating(String f, int nr) {
        String c = cu_f_map.get(f);
        int r = f_r_map.get(f);
        TreeMap<Integer, TreeSet<String>> mp = map.get(c);
        TreeSet<String> set = mp.get(r);
        set.remove(f);
        if (set.isEmpty()) mp.remove(r);
        insert(f, c, nr);
        f_r_map.put(f, nr);
    }

    public String highestRated(String c) {
        TreeMap<Integer, TreeSet<String>> mp = map.get(c);
        return mp.get(mp.lastKey()).first();
    }
}
