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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode front = head;
        ListNode fast = head;
        ListNode start = head; 

        // Reverse first half while finding the middle
        while (fast != null && fast.next != null) {
            front = curr.next;

            fast = fast.next.next;

            curr.next = prev;
            prev = curr;
            curr = front;
        }

        // If odd length, skip the middle element
        if (fast != null) {
            curr = curr.next;
        }

        // Compare reversed first half (prev) with second half (curr)
        while (curr != null) {
            if (prev.val != curr.val) {
                return false;
            }
            prev = prev.next;
            curr = curr.next;
        }

        return true;
    }
}
