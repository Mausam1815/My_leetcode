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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode(-1); // Dummy nodes for odd and even lists
        ListNode evenHead = new ListNode(-1);
        ListNode oddTail = oddHead; // Pointers to the tails of odd and even lists
        ListNode evenTail = evenHead;

        boolean isOdd = true;
        ListNode current = head;

        while (current != null) {
            if (isOdd) {
                oddTail.next = current;
                oddTail = oddTail.next;
            } else {
                evenTail.next = current;
                evenTail = evenTail.next;
            }

            current = current.next;
            isOdd = !isOdd;
        }

        oddTail.next = evenHead.next; // Connect the odd list to the even list
        evenTail.next = null; // Set the next pointer of the last node in the even list to null

        return oddHead.next; // Return the merged list starting from the first odd node
    }
}