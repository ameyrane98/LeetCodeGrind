/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /**haire and tortoise algo */
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow= head;
        ListNode fast= head;
        //this loops detect the cycle
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                break;
            }
        }
        // If no cycle exists, return null
        if (fast == null || fast.next == null) {
            return null;
        }

        //
        ListNode slow2=head;
        
        while(slow!=slow2){
            slow=slow.next;
            slow2=slow2.next;
        }

        return slow;



    }
}