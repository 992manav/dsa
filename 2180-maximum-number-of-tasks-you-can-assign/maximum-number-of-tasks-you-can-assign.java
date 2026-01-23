import java.util.*;

class Solution {

    int[] tasks;
    int[] workers;
    int pills;
    int strength;
    int n, m;

    int binary_search(int low, int high, int task, boolean[] removed) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            while (mid <= high && removed[mid]) mid++;
            if (mid > high) break;

            if (workers[mid] + strength >= task) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean kyapossiblehai(int x) {

        boolean[] removed = new boolean[m];
        int pillsLeft = pills;
        int t = x - 1;

        for (int w = m - 1; w >= Math.max(0,m-1-x) && t >= 0; w--) {

            if (removed[w]) continue;

            if (workers[w] >= tasks[t]) {
                t--;
            } else {
                if (pillsLeft == 0) return false;

                int idx = binary_search(Math.max(0,m-1-x), w, tasks[t], removed);
                if (idx == -1) return false;

                removed[idx] = true;

                pillsLeft--;

                if(idx!=w){
                    w++;
                }
                t--;
            }
        }

        return t < 0;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {

        this.tasks = tasks;
        this.workers = workers;
        this.pills = pills;
        this.strength = strength;

        n = tasks.length;
        m = workers.length;

        Arrays.sort(tasks);
        Arrays.sort(workers);

        int low = 0, high = Math.min(n, m);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (kyapossiblehai(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
