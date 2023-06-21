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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode a =head;
        ListNode b = head;
        ListNode c = head;
        // get kth node from start
        while(k > 1){
            a = a.next;
            c= c.next;
            k--;
        }
        // get kth node from end
        while(c.next != null){
            c = c.next;
            b = b.next;
        }
        // swap a and b node
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        
        return head;
    }
}