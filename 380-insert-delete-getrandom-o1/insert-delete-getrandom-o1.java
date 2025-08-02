import java.util.*;

class RandomizedSet {

    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int n = (int)(Math.random() * set.size());
        return new ArrayList<>(set).get(n);
    }
}
