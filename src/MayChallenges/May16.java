package MayChallenges;

/*
May 16

Question: Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
*/

class May16 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode start = head, end = head;

        int length = 0;
        while (end.next != null) {
            end = end.next;
            length++;
        }

        int count = (length % 2 == 0) ? (length / 2) : (length / 2) + 1;

        while (count > 0) {
            end.next = start.next;
            start.next = start.next.next;
            end.next.next = null;

            start = start.next;
            end = end.next;
            count--;
        }

        return head;
    }
}
