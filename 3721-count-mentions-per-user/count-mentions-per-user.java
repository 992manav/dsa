class Solution {
    public int[] countMentions(int n, List<List<String>> events) {
        int[] freq = new int[n];
        
        // Sort: pehle timestamp, phir OFFLINE before MESSAGE
        events.sort((a, b) -> {
            int timeCompare = Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
            if (timeCompare != 0) return timeCompare;
            if (a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            if (a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")) return 1;
            return 0;
        });
        
        Map<Integer, Integer> offlineTime = new HashMap<>();
        int tot = 0;

        for (int i = 0; i < events.size(); i++) {
            List<String> lst = events.get(i);
            int timestamp = Integer.parseInt(lst.get(1));

            if (lst.get(0).equals("OFFLINE")) {
                // Single ID hai, split nahi karna
                int id = Integer.parseInt(lst.get(2));
                offlineTime.put(id, timestamp);
                
            } else { // MESSAGE
                String s = lst.get(2);

                if (s.equals("ALL")) {
                    tot++;
                    
                } else if (s.equals("HERE")) {
                    tot++;
                    // Offline users ko subtract karo
                    for (Integer key : offlineTime.keySet()) {
                        int offTime = offlineTime.get(key);
                        // Agar user abhi bhi offline hai
                        if (timestamp < offTime + 60) {
                            freq[key]--;
                        }
                    }
                    
                } else {
                    // Individual IDs
                    String[] arr = s.split(" ");
                    for (String index : arr) {
                        if (index.startsWith("id")) {
                            int id = Integer.parseInt(index.substring(2));
                            freq[id]++;
                        }
                    }
                }
            }
        }

        // Sabko tot add karo
        for (int i = 0; i < n; i++) {
            freq[i] += tot;
        }

        return freq;
    }
}