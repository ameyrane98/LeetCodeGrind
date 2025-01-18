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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Find the kth node from groupPrev
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break; // No more groups to reverse
            }

            // Mark the start and end of the group
            ListNode groupNext = kth.next;
            ListNode groupStart = groupPrev.next;

            // Reverse the group
            reverse(groupStart, groupNext);

            // Update the connections
            groupPrev.next = kth;
            groupStart.next = groupNext;

            // Move to the next group
            groupPrev = groupStart;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }
}
