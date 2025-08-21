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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==null || left==right){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        for(int i=1; i<left; i++){
            prev=curr;
            curr=curr.next;
        }

        ListNode beforeLeft = prev;
        ListNode leftNode = curr;
        ListNode reversed = null;
        for(int i=0; i<right-left+1; i++){
            ListNode nextNode=curr.next;
            curr.next=reversed;
            reversed=curr;

            curr=nextNode;
        }
        
       if (beforeLeft != null) {
            beforeLeft.next = reversed;
        } else {
            head = reversed; // if left == 1
        }
        leftNode.next = curr;

        return head;

      
    }

    
}