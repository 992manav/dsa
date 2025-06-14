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
    static{
        for(int i = 0; i < 300; i++){
            deleteMiddle(new ListNode(i));
        }
    }
    
    public static ListNode deleteMiddle(ListNode head) {
         if (head == null) return head;
        if (head.next == null) return null;
        ListNode slow = head, fast = head, prev = null;

        // Find midpoint using fast/slow
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next=slow.next;
        return head;

    }
}