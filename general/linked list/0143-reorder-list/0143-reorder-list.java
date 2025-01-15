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
    /** T(n)= O(n), Space(n)= O(1) using fast/slow pointer*/
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

         // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }

    /** T(n)= O(n), Space(n)= O(n)  using Stack*/
    // public void reorderList(ListNode head) {
    //     if(head==null || head.next==null){
    //         return;
    //     }

    //     Stack<ListNode> stck = new Stack<>();
    //     int length=0;
    //     ListNode current = head;
    //     while(current!=null){
    //         stck.push(current);
    //         current=current.next;
    //         length++;
    //     }

    //     int steps= length/2;
    //     current=head;

    //     while(steps-- > 0){
    //         ListNode tailnode= stck.pop();
    //         ListNode nextnode=current.next;
    //         current.next=tailnode;
    //         tailnode.next=nextnode;
    //         current=nextnode;

    //     }
        
    //     current.next=null;
    // }
}