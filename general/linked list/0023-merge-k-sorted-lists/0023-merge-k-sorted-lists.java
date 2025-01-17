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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int i = 0 ; i <lists.length ; i++){
            ListNode curr=lists[i];
            while(curr!=null){
                p.add(curr.val);
                curr=curr.next;
            }
        }
    

          // Create a dummy node to start building the result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Extract elements from the PriorityQueue and build the merged list
        while (!p.isEmpty()) {
            tail.next = new ListNode(p.poll());
            tail = tail.next;
        }

        // Return the merged list
        return dummy.next;

    }
}