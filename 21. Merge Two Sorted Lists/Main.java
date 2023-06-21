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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create new list for merging both list in sorted way
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // iterate through both list and add smaller value first
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        // if any list has node left
        if(list1 != null){
            tail.next = list1;
        }else if(list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}