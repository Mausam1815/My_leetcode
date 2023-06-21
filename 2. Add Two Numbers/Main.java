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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create a dummy node for result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // create carry variable for storing carry
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum%10);
            carry = sum/10;
            current = current.next;
        }
        // if carry is not 0 then add new node to the result list
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}