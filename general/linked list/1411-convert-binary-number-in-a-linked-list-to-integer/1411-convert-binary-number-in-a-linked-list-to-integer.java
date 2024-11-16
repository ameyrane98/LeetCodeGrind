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
    public int getDecimalValue(ListNode head) {
        if(head==null){
            return 0;
        }
        StringBuilder str= new StringBuilder();
        helper(head,str);

        return Integer.parseInt(str.toString(),2);
    }

    public void helper(ListNode head, StringBuilder num){
        if(head==null){
            return ;
        }

        num.append(head.val);

        if(head.next!=null){
          helper(head.next,num);
        }

    }
}