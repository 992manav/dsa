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

        if(head==null){
            return head;
        }else if(head.next==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        int count = 0;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        int mid = count;
        // System.out.println(mid);
        if (fast == null) { // even
            count = count * 2;
        } else { // odd
            count = count * 2 + 1;
        }

        // System.out.println(count);
        int index = count - n;
        // System.out.println(index);

        int t;
      
        if (index >= mid) {
            t = index - mid;
        } else {
            t = index;
            slow = head;
            prev = null;
        }
    //   System.out.println(t);
        while (slow != null) {
            if (t <= 0) {
                if(prev==null){
                    head=head.next;
                }else{
                     prev.next = slow.next;
                }
                return head;
            }
            t--;
            prev = slow;
            slow = slow.next;
        }

        return head;
    }
}
