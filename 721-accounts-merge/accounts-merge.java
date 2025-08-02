class Solution {

    int[] parent;
    int[] rank;

    public int find_parent(int p) {
        if (parent[p] == p) {
            return p;
        }
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
        parent = new int[acc.size()];
        rank = new int[acc.size()];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < acc.size(); i++) {
            int parent1 = i;
            for (int parent2 = i + 1; parent2 < acc.size(); parent2++) {
                if (acc.get(parent1).get(0).equals(acc.get(parent2).get(0))) {
                    int purvaj1 = find_parent(parent1);
                    int purvaj2 = find_parent(parent2);
                    if (purvaj1 != purvaj2) {
                        boolean flag = false;
                        for (int j = 1; j < acc.get(parent1).size(); j++) {
                            for (int k = 1; k < acc.get(parent2).size(); k++) {
                                if (acc.get(parent1).get(j).equals(acc.get(parent2).get(k))) {
                                    unionByRank(purvaj1, purvaj2);
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            int p = find_parent(i);
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }

        List<List<String>> final_lst = new ArrayList<>();

        for (int key : map.keySet()) {
            List<String> lst = new ArrayList<>();
            lst.add(acc.get(key).get(0));

            Set<String> emails = new HashSet<>();

            for (int i : map.get(key)) {
                for (int j = 1; j < acc.get(i).size(); j++) {
                    emails.add(acc.get(i).get(j));
                }
            }

            List<String> sortedEmails = new ArrayList<>(emails);
            Collections.sort(sortedEmails);
            lst.addAll(sortedEmails);

            final_lst.add(lst);
        }

        return final_lst;
    }
}
