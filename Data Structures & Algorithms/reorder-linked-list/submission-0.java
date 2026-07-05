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
    public void reorderList(ListNode head) {
        ListNode mid = findMidNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseList(head2);
        mergeList(head, head2);
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head.next;

        // Find mid of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode curr1 = head1, curr2 = head2;
        while(curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }
}
