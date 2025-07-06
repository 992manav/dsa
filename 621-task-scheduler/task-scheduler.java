class Solution { 
    public int leastInterval(char[] tasks, int n) { 
        int[] count = new int[26]; 
        Arrays.fill(count, 0); 
 
        for (int i = 0; i < tasks.length; i++) { 
            int index = tasks[i] - 'A'; 
            count[index] += 1; 
        } 
 
        Arrays.sort(count); 
        
        int max = count[25]; // max frequency
        int maxGroupCount = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] == max) {
                maxGroupCount++;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + maxGroupCount);
    }
}
