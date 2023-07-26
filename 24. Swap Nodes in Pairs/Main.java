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
    public ListNode swapPairs(ListNode head) {
//		if (head == null) { // this will not pass while loop below
//			return head;
//		}

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;

            // if only one node left, then no swap
            while (prev.next != null && prev.next.next != null) {

                ListNode first = prev.next;
                ListNode second = first.next;

                ListNode third = second.next;

                // swap
                prev.next = second;
                second.next = first;
                first.next = third;

                prev = prev.next.next;
            }

        return dummy.next;
    }
}