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
            for (int j = i + 1; j < n; j++) {
                if (!acc.get(j).get(0).equals(name1)) continue;

                int p1 = find_parent(i);
                int p2 = find_parent(j);
                if (p1 == p2) continue;

                List<String> list1 = acc.get(i);
                List<String> list2 = acc.get(j);

                Set<String> set1 = new HashSet<>(list1.subList(1, list1.size()));
                for (int k = 1; k < list2.size(); k++) {
                    if (set1.contains(list2.get(k))) {
                        unionByRank(p1, p2);
                        break;
                    }
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = find_parent(i);
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }

        List<List<String>> final_lst = new ArrayList<>();

        for (int key : map.keySet()) {
            List<String> lst = new ArrayList<>();
            List<Integer> indices = map.get(key);
            lst.add(acc.get(indices.get(0)).get(0));

            Set<String> emailSet = new HashSet<>();
            for (int idx : indices) {
                List<String> emails = acc.get(idx);
                for (int j = 1; j < emails.size(); j++) {
                    emailSet.add(emails.get(j));
                }
            }

            List<String> emailList = new ArrayList<>(emailSet);
            Collections.sort(emailList);
            lst.addAll(emailList);

            final_lst.add(lst);
        }

        return final_lst;
    }
}
