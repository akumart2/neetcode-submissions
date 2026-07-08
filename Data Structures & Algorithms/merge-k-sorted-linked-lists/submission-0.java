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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        // Populate the minHeap with first node of each list.

        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
