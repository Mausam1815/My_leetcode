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
    public boolean isPalindrome(ListNode head) {
    //    an empty list and single noded list considered as palindrome
        if(head == null || head.next == null){
            return true;
        }
        // if list have more than 1 node
        // find middle node and reverse starting of the list till middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null || fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        // splitting of list into two list from middle
        ListNode firstHalf = prev;
        ListNode secondHalf = fast==null ? slow : slow.next;
        // check palindrome by iteration
        // if any value doesn't match, list is not a palindrome
        while(firstHalf != null || secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}