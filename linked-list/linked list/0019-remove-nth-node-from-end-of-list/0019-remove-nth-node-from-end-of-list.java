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
        ListNode temp=head;

        while(temp!=null){
            length++;
            temp=temp.next;
        }
        if (n == length) {
            return head.next;
        }

        int nodePos= length-n-1; // 5-2;
        ListNode prev=head;

        while(nodePos>0){
            prev=prev.next;
            nodePos--;
        }

        prev.next=prev.next.next;

        return head;
    }
}