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

    ListNode reverse(ListNode prev,ListNode curr,ListNode front){

        if(curr==null){
            return prev;
        }
        front=curr.next;
        curr.next=prev;
        
        return reverse(curr,front,front);

    }

    public ListNode reverseList(ListNode head) {
       
        ListNode prev=null;
        ListNode curr=head;
        ListNode front=head;
    
       return reverse(prev,curr,front);
    }
}