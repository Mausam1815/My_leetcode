/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        // Step 1: Duplicate nodes and insert them after the original nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Set random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copied lists
        current = head;
        Node newHead = head.next;
        Node copiedCurrent = newHead;
        while (current != null) {
            current.next = current.next.next;
            if (copiedCurrent.next != null) {
                copiedCurrent.next = copiedCurrent.next.next;
            }
            current = current.next;
            copiedCurrent = copiedCurrent.next;
        }

        return newHead;
    }
}