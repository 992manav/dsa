class Solution {

    double solve(String sx, String sy, String op) {
        double x = Double.parseDouble(sx);
        double y = Double.parseDouble(sy);

        switch (op) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return y != 0 ? x / y : Double.NaN;
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    boolean checkFivePossibility(String[] store) {
        double a = Double.parseDouble(store[0]);
        char op1 = store[1].charAt(0);
        double b = Double.parseDouble(store[2]);
        char op2 = store[3].charAt(0);
        double c = Double.parseDouble(store[4]);
        char op3 = store[5].charAt(0);
        double d = Double.parseDouble(store[6]);

        double left1 = solve(String.valueOf(a), String.valueOf(b), String.valueOf(op1));
        double right1 = solve(String.valueOf(c), String.valueOf(d), String.valueOf(op3));
        if (Math.abs(solve(String.valueOf(left1), String.valueOf(right1), String.valueOf(op2)) - 24) < 1e-6) return true;

        double left2 = solve(String.valueOf(a), String.valueOf(b), String.valueOf(op1));
        double mid2 = solve(String.valueOf(left2), String.valueOf(c), String.valueOf(op2));
        if (Math.abs(solve(String.valueOf(mid2), String.valueOf(d), String.valueOf(op3)) - 24) < 1e-6) return true;

        double mid3 = solve(String.valueOf(b), String.valueOf(c), String.valueOf(op2));
        double left3 = solve(String.valueOf(a), String.valueOf(mid3), String.valueOf(op1));
        if (Math.abs(solve(String.valueOf(left3), String.valueOf(d), String.valueOf(op3)) - 24) < 1e-6) return true;

        double mid4 = solve(String.valueOf(b), String.valueOf(c), String.valueOf(op2));
        double right4 = solve(String.valueOf(mid4), String.valueOf(d), String.valueOf(op3));
        if (Math.abs(solve(String.valueOf(a), String.valueOf(right4), String.valueOf(op1)) - 24) < 1e-6) return true;

        double mid5 = solve(String.valueOf(c), String.valueOf(d), String.valueOf(op3));
        double right5 = solve(String.valueOf(b), String.valueOf(mid5), String.valueOf(op2));
        if (Math.abs(solve(String.valueOf(a), String.valueOf(right5), String.valueOf(op1)) - 24) < 1e-6) return true;

        return false;
    }

    boolean fun(int cur_index, int index, int[] arr, String[] store, char[] op, int op_index) {
        if (cur_index == arr.length) {
            if (checkFivePossibility(store)) return true;
            return false;
        }

        for (int i = cur_index; i < arr.length; i++) {
            swap(i, cur_index, arr);
            String temp = store[index];
            store[index] = String.valueOf(arr[cur_index]);

            if (cur_index < arr.length - 1) {
                for (int j = 0; j < op.length; j++) {
                    store[op_index] = String.valueOf(op[j]);
                    if (fun(cur_index + 1, index + 2, arr, store, op, op_index + 2))
                        return true;
                }
            } else {
                if (fun(cur_index + 1, index + 1, arr, store, op, op_index))
                    return true;
            }

            store[index] = temp;
            swap(i, cur_index, arr);
        }

        return false;
    }

    void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean judgePoint24(int[] cards) {
        char[] op = new char[] {'+', '-', '*', '/'};
        String[] store = new String[7]; 
        return fun(0, 0, cards, store, op, 1);
    }
}
