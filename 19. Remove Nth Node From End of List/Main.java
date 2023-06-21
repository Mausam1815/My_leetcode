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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listLen = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            listLen++;
        }
        int toRemove = listLen-n;
        curr = head;
        int ctr = 0;
        if(curr != null && ctr == toRemove){
            head = curr.next;
            return head;
        }

        ListNode prev = null;
        while(curr != null && ctr < toRemove){
            ctr++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }
}