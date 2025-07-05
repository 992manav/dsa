import java.util.*;

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

        List<Project> lst = new ArrayList<>();

        // Pull from heap to list sorted by profit
        while (!pq.isEmpty()) {
            lst.add(pq.poll());
        }

        while (k > 0) {
            boolean found = false;

            Iterator<Project> it = lst.iterator();

            while (it.hasNext()) {
                Project p = it.next();
                if (p.capital <= w) {
                    w += p.profit;
                    it.remove();  // Safe and fast removal
                    k--;
                    found = true;
                    break;
                }
            }

            if (!found) break;
        }

        return w;
    }
}
