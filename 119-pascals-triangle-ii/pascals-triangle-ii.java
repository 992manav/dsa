import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        row.add((int) val); 

        for (int col = 0; col < rowIndex; col++) {
            val = val * (rowIndex - col) / (col + 1);
            row.add((int) val);
        }

        return row;
    }
}
