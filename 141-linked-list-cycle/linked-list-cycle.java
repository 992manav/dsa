/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp=head;
        boolean flag=false;
        while(temp!=null){
            if(temp.val==Integer.MIN_VALUE){
                flag=true;
                break;
            }
            temp.val=Integer.MIN_VALUE;
            temp=temp.next;
        }
        return flag;
    }
}