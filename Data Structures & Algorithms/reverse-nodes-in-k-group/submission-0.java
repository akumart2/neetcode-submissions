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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy, curr = head, next = null;
        while (curr != null) {
            ListNode kthNode = getKthNode(curr, k);
            //System.out.println("kth: " + kthNode);
            if (kthNode != null) {
                // break the list after kth node
                next = kthNode.next;
                kthNode.next = null;
                ListNode tempHead = reverseList(curr);
                prev.next = tempHead;
                prev = curr;
                curr = next;
            }
            else {
                prev.next = curr;
                curr = null;
            }
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode curr = head;
        while (curr != null && k-- > 1) {
            curr = curr.next;
        }

        return curr;
    }
}
