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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;

        while(curr!=null){
             
            // Step 1: Skip m - 1 nodes (stop at the m-th node)
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            // If reached end, break
            if (curr == null) break;

            // Step 2: Start from next node and delete n nodes
            ListNode temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            // Step 3: Link back
            curr.next = temp;

            // Step 4: Move curr to continue from where we left off
            curr = temp;
        }

        return head;
    }
}