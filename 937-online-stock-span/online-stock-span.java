import java.util.Stack;


class StockSpanner {

    Stack<Pair<Integer, Integer>> st;
    int i;

    public StockSpanner() {
        st = new Stack<>();
        i = 0;
    }

    public int next(int price) {
        i++;
        
        while (!st.isEmpty() && st.peek().getKey() <= price) {
            st.pop();
        }

        int span;
        if (st.isEmpty()) {
            span = i;
        } else {
            span = i - st.peek().getValue();
        }

        st.push(new Pair<>(price, i)); // Push current price and day index
        return span;
    }
}
