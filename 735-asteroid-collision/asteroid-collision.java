import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
                int asteroid = arr[i];
                if (asteroid > 0) {
                    st.push(asteroid);
                } else {
                    int absAsteroid = -asteroid;
                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < absAsteroid) {
                        st.pop();
                    }
                    if (!st.isEmpty() && st.peek() == absAsteroid) {
                        st.pop(); 
                    } else if (st.isEmpty() || st.peek() < 0) {
                        st.push(asteroid);
                    }
                }

        }

        int[] result = new int[st.size()];
        int index = result.length - 1;
        while (!st.isEmpty()) {
            result[index] = st.pop();
            index--;
        }

        return result;
    }
}
