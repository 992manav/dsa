import java.util.*;

class Solution {

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            while (!stack.isEmpty()) {
                int top = stack.peekLast();
                int g = gcd(top, cur);

                if (g == 1) {
                    break;
                }

                stack.pollLast();
                cur = lcm(top, cur);
            }

            stack.addLast(cur);
        }

        return new ArrayList<>(stack);
    }
}
