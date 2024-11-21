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
        int length=0;
        ListNode temp = head;
        while(temp!=null){
            length+=1;
            temp=temp.next;
        }

        int deletidx= length-n;
        if (deletidx == 0) {
            // Special case: Removing the head
            return head.next;
        }
        temp = head;
        for(int i=1; i<deletidx;i++){
            temp=temp.next;
        }
        
        
        temp.next=temp.next.next;
        
       

        return head;
    }
}