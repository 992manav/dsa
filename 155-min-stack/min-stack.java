class MinStack {

    Stack<Pair<Integer, Integer>> s1 = new Stack<>();

    public MinStack() {}

    public void push(int val) {
        if (s1.isEmpty()) {
            s1.push(new Pair<>(val, val));
        } else {
            int min = Math.min(val, s1.peek().getValue());
            s1.push(new Pair<>(val, min));
        }
    }

    public void pop() {
        s1.pop();
    }

    public int top() {
        return s1.peek().getKey();
    }

    public int getMin() {
        return s1.peek().getValue();
    }
}
