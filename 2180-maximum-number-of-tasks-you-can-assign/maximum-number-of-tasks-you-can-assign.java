import java.util.*;

class Solution {

    int[] saareTasks;
    int[] saareWorkers;
    int totalPills;
    int pillKiStrength;
    int totalTasks, totalWorkers;

    int lalluWorkerKhojo(int low, int high, int taskKiTakat, boolean[] alreadyUsed) {
        int milGayaIndex = -1;

        while (low <= high) {
            int beechKaIndex = low + (high - low) / 2;

            while (beechKaIndex <= high && alreadyUsed[beechKaIndex]) {
                beechKaIndex++;
            }
            if (beechKaIndex > high) break;

            if (saareWorkers[beechKaIndex] + pillKiStrength >= taskKiTakat) {
                milGayaIndex = beechKaIndex;
                high = beechKaIndex - 1;
            } else {
                low = beechKaIndex + 1;
            }
        }
        return milGayaIndex;
    }

    boolean kyaYePossibleHai(int kitneTasks) {

        boolean[] alreadyUsed = new boolean[totalWorkers];
        int bachiHuiPills = totalPills;
        int taskPointer = kitneTasks - 1;

        for (int workerPointer = totalWorkers - 1;workerPointer >= Math.max(0, totalWorkers - 1 - kitneTasks) && taskPointer >= 0;workerPointer--) {

            if (alreadyUsed[workerPointer]) continue;

            if (saareWorkers[workerPointer] >= saareTasks[taskPointer]) {
                taskPointer--;
            } else {
                if (bachiHuiPills == 0) return false;

                int lalluWorkerIndex = lalluWorkerKhojo(
                    Math.max(0, totalWorkers - 1 - kitneTasks),
                    workerPointer,
                    saareTasks[taskPointer],
                    alreadyUsed
                );

                if (lalluWorkerIndex == -1) return false;

                alreadyUsed[lalluWorkerIndex] = true;
                bachiHuiPills--;

                if (lalluWorkerIndex != workerPointer) {
                    workerPointer++;
                }
                taskPointer--;
            }
        }

        return taskPointer < 0;
    }

    public int maxTaskAssign(
        int[] tasks,
        int[] workers,
        int pills,
        int strength
    ) {

        this.saareTasks = tasks;
        this.saareWorkers = workers;
        this.totalPills = pills;
        this.pillKiStrength = strength;

        totalTasks = saareTasks.length;
        totalWorkers = saareWorkers.length;

        Arrays.sort(saareTasks);
        Arrays.sort(saareWorkers);

        int low = 0;
        int high = Math.min(totalTasks, totalWorkers);
        int finalAnswer = 0;

        while (low <= high) {
            int midTasks = low + (high - low) / 2;

            if (kyaYePossibleHai(midTasks)) {
                finalAnswer = midTasks;
                low = midTasks + 1;
            } else {
                high = midTasks - 1;
            }
        }

        return finalAnswer;
    }
}
