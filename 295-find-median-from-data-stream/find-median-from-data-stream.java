import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> pq1; 
    PriorityQueue<Integer> pq2; 

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        pq2 = new PriorityQueue<>(); // min-heap
    }

    public void addNum(int num) {

        int top2;
        if(pq2.isEmpty()) {
            top2 = Integer.MIN_VALUE;
        } else {
            top2 = pq2.peek();
        }

        if(num < top2) {
            pq1.add(num);
        } else {
            pq2.add(num);
        }

        if(pq1.size() == pq2.size() + 2) {
            pq2.add(pq1.peek());
            pq1.poll();
        } else if(pq2.size() == pq1.size() + 2) {
            pq1.add(pq2.peek());
            pq2.poll();
        }
    }

    public double findMedian() {
        if(pq1.size() == pq2.size()) {
            return ((double)pq1.peek() + (double)pq2.peek()) / 2.0;
        }
        if(pq1.size() > pq2.size()) {
            return pq1.peek();
        }
        return pq2.peek();
    }
}
