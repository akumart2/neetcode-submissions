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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, rear = head;
        while (n-- > 0) {
            front = front.next;
        }

        if (front == null) return head.next;

        ListNode prev = null;
        while (front != null) {
            prev = rear;
            rear = rear.next;
            front = front.next;
        }

        prev.next = rear.next;
        rear.next = null;
        return head;
    }
}
