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
    public ListNode plusOne(ListNode head) {
        ListNode newHead = reversed(head);

        int carry=1;
        ListNode curr = newHead;
        ListNode prev = null;

        while(curr!=null && carry>0){
            int sum = curr.val+carry;
            curr.val = sum % 10;
            carry = sum / 10 ;

            prev= curr;
            curr=curr.next;
        }

        if(carry>0){
            prev.next= new ListNode(carry);
        }

        return reversed(newHead);
    }

    public ListNode reversed(ListNode head){
        ListNode prev=null; 
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}