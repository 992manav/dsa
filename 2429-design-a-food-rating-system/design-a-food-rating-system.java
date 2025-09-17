import java.util.*;

class FoodRatings {
    private final Map<String, TreeMap<Integer, TreeSet<String>>> map = new HashMap<>();
    private final Map<String, String> cu_f_map = new HashMap<>();
    private final Map<String, Integer> f_r_map = new HashMap<>();

    public void insert(String f, String c, int r) {
        map.computeIfAbsent(c, k -> new TreeMap<>())
           .computeIfAbsent(r, k -> new TreeSet<>())
           .add(f);
    }

    public FoodRatings(String[] foods, String[] cus, int[] rat) {
        for (int i = 0; i < foods.length; i++) {
            cu_f_map.put(foods[i], cus[i]);
            f_r_map.put(foods[i], rat[i]);
            insert(foods[i], cus[i], rat[i]);
        }
    }

    public void changeRating(String f, int nr) {
        String c = cu_f_map.get(f);
        int oldR = f_r_map.get(f);
        TreeMap<Integer, TreeSet<String>> mp = map.get(c);

        TreeSet<String> oldSet = mp.get(oldR);
        oldSet.remove(f);
        if (oldSet.isEmpty()) mp.remove(oldR);

        f_r_map.put(f, nr);
        mp.computeIfAbsent(nr, k -> new TreeSet<>()).add(f);
    }

    public String highestRated(String c) {
        return map.get(c).lastEntry().getValue().first();
    }
}
