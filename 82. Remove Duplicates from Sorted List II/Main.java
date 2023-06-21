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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        int d = head.val;
        if(head.next.val != d) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while(head != null && d == head.val) 
            head = head.next;
        return deleteDuplicates(head);
    }
}