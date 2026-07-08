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
        // Interleave new nodes in old list
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        //printList(head);

        // Set randoms for newly created nodes
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }
        //printList(head);

        // Separate new nodes from old list and return as a new list
        Node dummy = new Node(0);
        Node curr1 = head, prev2 = dummy;
        while(curr1 != null) {
            Node curr2 = curr1.next;
            curr1.next = curr2.next;
            prev2.next = curr2;
            prev2 = curr2;
            curr1 = curr1.next;
        }

        //printList(dummy.next);
        return dummy.next;
    }

    private void printList(Node head) {
        while(head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }

        System.out.println();
    }
}
