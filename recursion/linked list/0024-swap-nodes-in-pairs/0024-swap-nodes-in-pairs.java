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
    public ListNode swapPairs(ListNode head) {
    
        if(head==null|| head.next==null){
            return head;
        }

 
        ListNode temp=head.next;
       // Recursive call for the rest of the list
        head.next = swapPairs(head.next.next);

        // Swap the current pair
        temp.next = head;
        

        return temp;
    }
}