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
    ArrayList<ListNode> arr = new ArrayList<>();
    public Solution(ListNode head) {
        while(head!=null){
            arr.add(head);
            head=head.next;
        }
    }
    
    public int getRandom() {
        int size =arr.size();
        int random = (int) (Math.random()*size);
        return arr.get(random).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */