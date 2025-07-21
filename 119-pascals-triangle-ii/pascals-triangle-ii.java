import java.util.*;

class Solution {
    public List<Integer> getRow(int rowNum) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int row = 1; row <= rowNum; row++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < row + 1; j++) {
                if (j == 0 || j == row) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j - 1) + prev.get(j)); 
                }
            }
            prev = curr;
        }

        return prev;
    }
}
