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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        int flag = 1;
        ListNode prev=null;

       while (temp1 != null  || temp2 != null ){

            if (temp1 == null) {
                prev=temp2;
                int y = temp2.val;
                temp2.val = (y + carry) % 10;
                carry = (y + carry) / 10;
                temp2 = temp2.next;
                flag = 2;
            } else if (temp2 == null) {
                prev=temp1;
                int x = temp1.val;
                temp1.val = (x + carry) % 10;
                carry = (x + carry) / 10;
                temp1 = temp1.next;
                flag = 1;
            } else {
                prev=temp1;
                int x = temp1.val;
                int y = temp2.val;
                temp1.val = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                temp2.val = temp1.val;
                temp1 = temp1.next;
                temp2 = temp2.next;

            }
        }

        if (carry != 0 && prev!=null) {
            if (flag == 1) {
                prev.next = new ListNode(carry, null); // ✅ fixed
            } else {
                prev.next = new ListNode(carry, null); // ✅ fixed
            }
        }

        if (flag == 1) {
            return l1;
        } else {
            return l2;
        }
    }
}
