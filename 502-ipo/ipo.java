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

        // Move all projects from priority queue to list (sorted by profit)
        while (!pq.isEmpty()) {
            Project p = pq.poll();
            lst.add(p);
        }

        while (k > 0) {
            boolean found = false;

            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).capital <= w) {
                    w += lst.get(i).profit;
                    lst.remove(i);  // Use the project once
                    found = true;
                    k--;
                    break;
                }
            }

            if (!found) break; // No project can be done
        }

        return w;
    }
}
