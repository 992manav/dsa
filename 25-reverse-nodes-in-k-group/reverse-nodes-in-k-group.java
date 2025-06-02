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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = temp;
        ListNode start = head;
        ListNode finish = null;
        int total = 0;

        // Count total nodes
        while (temp != null) {
            total++;
            temp = temp.next;
        }

        int remaining = total % k;
        temp = head;
        int c = 1;
        boolean firstPass = true;
        ListNode newHead = head;

        while (temp != null) {
            if (total - c + 1 == remaining) {
                return newHead;
            }

            int count = 0;
            prev = null;
            start = temp;

            // Reverse k nodes
            while (count < k && temp != null) {
                front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
                count++;
                c++;
            }

            if (firstPass) {
                newHead = prev;
                firstPass = false;
            }

            start.next = temp;
            if (finish != null) finish.next = prev;
            finish = start;
        }

        return newHead;
    }
}
