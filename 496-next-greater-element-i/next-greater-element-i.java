import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
          
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                map.put(nums2[i], st.peek());
            } else {
                map.put(nums2[i], -1);
            }

            st.push(nums2[i]);
        }

       
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}
