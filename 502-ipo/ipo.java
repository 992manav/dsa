import java.util.*;

class Solution {

    static class Project {
        int profit, capital;
        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Max-heap based on profit
        PriorityQueue<Project> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        // Add all projects into the priority queue
        for (int i = 0; i < n; i++) {
            pq.offer(new Project(profits[i], capital[i]));
        }

        while (k > 0) {
            boolean found = false;
            List<Project> temp = new ArrayList<>();

            // Try to find the most profitable affordable project
            while (!pq.isEmpty()) {
                Project curr = pq.poll();
                if (curr.capital <= w) {
                    w += curr.profit;
                    found = true;
                    k--;
                    break;
                } else {
                    temp.add(curr); // Not affordable yet
                }
            }

            // Put back unchosen projects
            pq.addAll(temp);

            if (!found) break; // no affordable project found
        }

        return w;
    }
}
