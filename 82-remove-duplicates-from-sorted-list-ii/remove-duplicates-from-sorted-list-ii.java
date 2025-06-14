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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        boolean flag = false;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                flag = true;
                temp.next = temp.next.next;
            } else {
                if (flag) {
                    if (prev == null) {
                        head = temp.next;
                    } else {
                        prev.next = temp.next;
                    }
                    flag = false;
                } else {
                    prev = temp;
                }
                temp = temp.next;
            }
        }

        return head;
    }
}
