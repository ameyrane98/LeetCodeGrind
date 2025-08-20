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
    int even=0;
    int odd=0;
    public String gameResult(ListNode head) {
        
        ListNode curr= head;
        while(curr!=null){
            if(curr.val>curr.next.val){
                even+=1;
            }else if(curr.val<curr.next.val){
                odd+=1;
            }
            curr=curr.next.next;
        }

        if(even>odd){
            return "Even";
        }else if(even<odd){
            return "Odd";
        }else{
            return "Tie";
        }

    }
}