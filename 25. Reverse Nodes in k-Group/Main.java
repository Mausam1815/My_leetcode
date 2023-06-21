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
        int count = 0;
        ListNode curr = head;
        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        if(count < k){
            return head;
        }

        count = 0;
        ListNode prev = null;
        ListNode next = null;
        curr = head;
        while(count < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null){
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}