class Solution { 
    public int[] dailyTemperatures(int[] temp) { 
        Stack<Integer> st = new Stack<>(); 
        int res[] = new int[temp.length]; 
        for (int i = temp.length - 1; i >= 0; i--) { 
            int curr_temp = temp[i]; 
            while (!st.isEmpty() && curr_temp >= temp[st.peek()]) { 
                st.pop(); 
            } 
            res[i] = st.isEmpty() ? 0 : st.peek() - i; 
            st.push(i); 
        } 
        return res; 
    } 
}
