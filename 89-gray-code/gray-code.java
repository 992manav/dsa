import java.util.*;

class Solution {

    boolean fun(int num, boolean[] arr, List<Integer> lst, int n) {

        if (lst.size() == (1 << n)) {   // fixed: lst.lenegth -> lst.size()
            return true;
        }

        if (arr[num]) {
            return false;
        }

        arr[num] = true;
        lst.add(num);

        for (int i = 0; i < n; i++) {
            int nextNum = num ^ (1 << i);
            if (fun(nextNum, arr, lst, n)) {
                return true;
            }
        }

        if (!lst.isEmpty()) {
            lst.remove(lst.size() - 1);
        }
        return false;
    }

    public List<Integer> grayCode(int n) {
        int size = (1 << n);
        boolean[] arr = new boolean[size];
        List<Integer> lst = new ArrayList<>();

        fun(0, arr, lst, n);

        return lst;
    }
}
