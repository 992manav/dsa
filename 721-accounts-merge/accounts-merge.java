class Solution {

    int[] parent;
    int[] rank;

    public int find_parent(int p) {
        if (parent[p] == p) return p;
        return parent[p] = find_parent(parent[p]);
    }

    void unionByRank(int parent1, int parent2) {
        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if (rank1 < rank2) {
            parent[parent1] = parent2;
        } else if (rank2 < rank1) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n = acc.size();
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            String name1 = acc.get(i).get(0);
            Set<String> emails1 = new HashSet<>(acc.get(i).subList(1, acc.get(i).size()));

            for (int j = i + 1; j < n; j++) {
                if (!acc.get(j).get(0).equals(name1)) continue;

                int p1 = find_parent(i);
                int p2 = find_parent(j);
                if (p1 == p2) continue;

                List<String> acc2 = acc.get(j);
                boolean matched = false;
                for (int k = 1; k < acc2.size(); k++) {
                    if (emails1.contains(acc2.get(k))) {
                        unionByRank(p1, p2);
                        matched = true;
                        break;
                    }
                }
                // Optionally update emails1 set to reduce future checks
                if (matched) {
                    emails1.addAll(acc2.subList(1, acc2.size()));
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = find_parent(i);
            map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }

        List<List<String>> final_lst = new ArrayList<>();

        for (int key : map.keySet()) {
            List<Integer> groupIndices = map.get(key);
            Set<String> emailSet = new HashSet<>();
            String name = acc.get(groupIndices.get(0)).get(0);

            for (int idx : groupIndices) {
                List<String> accEntry = acc.get(idx);
                for (int j = 1; j < accEntry.size(); j++) {
                    emailSet.add(accEntry.get(j));
                }
            }

            List<String> merged = new ArrayList<>();
            merged.add(name);

            List<String> sortedEmails = new ArrayList<>(emailSet);
            Collections.sort(sortedEmails);
            merged.addAll(sortedEmails);

            final_lst.add(merged);
        }

        return final_lst;
    }
}
