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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1; 
        }

        if (head1.val > head2.val) {
            ListNode temp = head1;
            head1 = head2;
            head2 = temp; 
        }

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode prev1 = temp1;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                prev1 = temp1;
                temp1 = temp1.next;
            } else {
                prev1.next = temp2;
                temp2 = temp2.next;
                prev1 = prev1.next;
                prev1.next = temp1;
            }
        }

        if (temp2 != null) {
            prev1.next = temp2;
        }

        return head1;
    }
}
