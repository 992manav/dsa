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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (head.next == null) return null;

        ListNode slow = head, fast = head, prev = null;
        int count = 0;

        // Find midpoint using fast/slow
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        int totalLength = (fast == null) ? count * 2 : count * 2 + 1;
        int indexToRemove = totalLength - n;

        int t = (indexToRemove >= count) ? indexToRemove - count : indexToRemove;

        // Reset slow and prev if removal is before midpoint
        if (indexToRemove < count) {
            slow = head;
            prev = null;
        }

        while (slow != null) {
            if (t == 0) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = slow.next;
                }
                break;
            }
            t--;
            prev = slow;
            slow = slow.next;
        }

        return head;
    }
}
