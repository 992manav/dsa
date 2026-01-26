import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;
        int min_d = Integer.MAX_VALUE;
        List<List<Integer>> final_lst = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int d = arr[i + 1] - arr[i];

            if (d == min_d) {
                final_lst.add(Arrays.asList(arr[i], arr[i + 1]));
            } 
            else if (d < min_d) {
                min_d = d;
                final_lst = new ArrayList<>();
                final_lst.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return final_lst;
    }
}
