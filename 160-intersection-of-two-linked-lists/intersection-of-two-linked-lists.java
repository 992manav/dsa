public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while(temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        ListNode temp2 = headB;
        while(temp2 != null){
            if(set.contains(temp2)){
                return temp2; 
            }
            temp2 = temp2.next;
        }
        return null;
    }
}
