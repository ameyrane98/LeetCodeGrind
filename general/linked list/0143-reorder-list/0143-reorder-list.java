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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        Stack<ListNode> stck = new Stack<>();
        int length=0;
        ListNode current = head;
        while(current!=null){
            stck.push(current);
            current=current.next;
            length++;
        }

        int steps= length/2;
        current=head;

        while(steps-- > 0){
            ListNode tailnode= stck.pop();
            ListNode nextnode=current.next;
            current.next=tailnode;
            tailnode.next=nextnode;
            current=nextnode;

        }
        
        current.next=null;
    }
}