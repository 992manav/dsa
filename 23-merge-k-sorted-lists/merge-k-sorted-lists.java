/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> (x.val - y.val));

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                pq.offer(a[i]);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (!pq.isEmpty()) {
            ListNode root = pq.poll();
            temp.next = root;
            temp = temp.next;
            root = root.next;

            while (root != null && (!pq.isEmpty() && root.val <= pq.peek().val)) {
                temp.next = root;
                temp = temp.next;
                root = root.next;
            }

            if (root != null) {
                pq.offer(root);
            }
        }

        return head.next;
    }
}
