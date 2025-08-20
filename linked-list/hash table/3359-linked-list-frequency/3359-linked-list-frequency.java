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
    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        ListNode curr = head;
        while(curr!=null){
            hmap.put(curr.val,hmap.getOrDefault(curr.val, 0)+1);
            curr=curr.next;
        }

       ListNode dummy = new ListNode(-1);
        ListNode newCurr = dummy;

        for (int freq : hmap.values()) {
            newCurr.next = new ListNode(freq);
            newCurr = newCurr.next;
        }

        // Step 3: return new head
        return dummy.next;

       
    }
}