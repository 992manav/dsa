import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> final_list = new ArrayList<>();

    void fun(List<Integer> lst, int k, int target, int number, int sum) {

        if (sum == target && lst.size() == k) {
            final_list.add(new ArrayList<>(lst));
            return;
        }

        if (lst.size() > k) {
            return;
        }

        if (number > 9) {
            return;
        }

      

        lst.add(number);
        fun(lst, k, target, number + 1, sum + number);
        lst.remove(lst.size() - 1);
        fun(lst, k, target, number + 1, sum);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        if ((k * (k + 1)) / 2 > n) {
            return final_list;
        }

        if ((10 * k) - ((k * (k + 1)) / 2) < n) {
            return final_list;
        }

        fun(new ArrayList<>(), k, n, 1, 0);

        return final_list;
    }
}
