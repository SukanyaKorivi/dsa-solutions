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
        if(head == null ||head.next == null) return true;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;

        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        dummy.next=null;
        ListNode middle=slow;
        ListNode nextToMiddle=slow.next;
        middle.next=null;


        ListNode prev=null;
       ListNode curr=nextToMiddle;


       while(curr != null){
    
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        
       
       } 
       ListNode head2=prev;
        

       while(head != null && head2 != null){
        if(head.val == head2.val){
            head=head.next;
            head2=head2.next;
        }
        else{
            return false;
        }
       }
       return true;
    }
}