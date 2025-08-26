

import static java.lang.Math.random;

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

import java.util.Random;
class Solution {
    ArrayList<ListNode> arr= new ArrayList<>();
    int length=0;
    public Solution(ListNode head) {
        while(head!=null){
            arr.add(head);
            length++;
            head=head.next;
        }
        
    }
    
    public int getRandom() {
        Random rand = new Random();
        int radIndex = rand.nextInt(length);
        return arr.get(radIndex).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */