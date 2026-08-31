/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int curr1=length(headA);
        int curr2=length(headB);

        if(curr1<curr2) {
            int shift=curr2-curr1;
            for(int i=0;i<shift;i++ ){
                headB=headB.next;
            }
        }
        else{
            int shift=curr1-curr2;
            for(int i=0;i<shift;i++){
                headA=headA.next;
            }
        }

        while(headA != headB){
            headA=headA.next;
            headB=headB.next;

            
        }

        return headA;

        
    }

    public int length(ListNode head){
   
        ListNode curr=head;
        int count=0;

        while(curr != null){
            curr=curr.next;
            count++;
        }

        return count;
    }
}