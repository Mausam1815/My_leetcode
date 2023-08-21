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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;
        
        while (current != null) {
            ListNode prev = dummy;
            ListNode next = current.next;
            
            // Find the correct position to insert current node
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            // Insert current node between prev and prev.next
            current.next = prev.next;
            prev.next = current;
            
            current = next; // Move to the next unsorted node
        }
        
        return dummy.next;
    }
}