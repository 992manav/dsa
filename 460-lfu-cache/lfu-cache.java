import java.util.HashMap;
import java.util.LinkedHashMap;

class LFUCache {

    HashMap<Integer, LinkedHashMap<Integer, Integer>> mainmap = new HashMap<>();
    HashMap<Integer, Integer> freqmap = new HashMap<>();
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (freqmap.containsKey(key)) {
            int fre = freqmap.get(key);
            LinkedHashMap<Integer, Integer> thismap = mainmap.get(fre);
            int value = thismap.get(key);
            thismap.remove(key); // Remove from current frequency level

            fre++;
            freqmap.put(key, fre);

            // Put into the next frequency level
            mainmap.computeIfAbsent(fre, k -> new LinkedHashMap<>(16, 0.75f, true))
                   .put(key, value);

            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (freqmap.containsKey(key)) {
            int fre = freqmap.get(key);
            LinkedHashMap<Integer, Integer> thismap = mainmap.get(fre);
            thismap.remove(key); // Remove from old frequency

            fre++;
            freqmap.put(key, fre);

            // Put into updated frequency map with LRU behavior
            mainmap.computeIfAbsent(fre, k -> new LinkedHashMap<>(16, 0.75f, true))
                   .put(key, value);
        } else {
            if (freqmap.size() >= capacity) {
                // Find the minimum frequency with at least one entry
                int minFreq = Integer.MAX_VALUE;
                for (int f : mainmap.keySet()) {
                    if (!mainmap.get(f).isEmpty()) {
                        minFreq = Math.min(minFreq, f);
                    }
                }

                // Remove LRU key from that frequency level
                LinkedHashMap<Integer, Integer> minFreqMap = mainmap.get(minFreq);
                int evictKey = minFreqMap.keySet().iterator().next(); // true LRU due to accessOrder
                minFreqMap.remove(evictKey);
                freqmap.remove(evictKey);
            }

            // Insert new key at frequency 1
            freqmap.put(key, 1);
            mainmap.computeIfAbsent(1, k -> new LinkedHashMap<>(16, 0.75f, true))
                   .put(key, value);
        }
    }
}
