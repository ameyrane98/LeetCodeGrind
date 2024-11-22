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
        // one pass method
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode slow = dummy;
        ListNode fast=dummy;

        for(int i=1; i<=n+1; i++){
            fast=fast.next;
        }


        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;

        // Two pass method
        // int length=0;
        // ListNode temp = head;
        // while(temp!=null){
        //     length+=1;
        //     temp=temp.next;
        // }

        // int deletidx= length-n;
        // if (deletidx == 0) {
        //     // Special case: Removing the head
        //     return head.next;
        // }
        // temp = head;
        // for(int i=1; i<deletidx;i++){
        //     temp=temp.next;
        // }
        
        
        // temp.next=temp.next.next;
        
       

        // return head;


        return dummy.next;
    }
}