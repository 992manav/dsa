class Solution {

    class Project implements Comparable<Project> {
        int profit, capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo(Project other) {
            if (this.profit != other.profit) {
                return other.profit - this.profit;     // Descending profit
            } else {
                return this.capital - other.capital;   // Ascending capital
            }
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<Project> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Project(profits[i], capital[i]));
        }

        while (k > 0) {
            boolean found = false;
            List<Project> temp = new ArrayList<>();

            while (!pq.isEmpty()) {
                Project curr = pq.poll();
                if (curr.capital <= w) {
                    w += curr.profit;
                    k--;
                    found = true;
                    break;
                } else {
                    temp.add(curr); // Can't afford yet, keep aside
                }
            }

            pq.addAll(temp); // Put skipped projects back

            if (!found) break; // No project affordable → stop
        }

        return w;
    }
}
