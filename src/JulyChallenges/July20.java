package JulyChallenges;

/*
July 20

Question: Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
*/

class July20 {
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


    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        ListNode ptr = head;

        while (ptr != null && ptr.next != null) {
            if (ptr.next.val == val)
                ptr.next = ptr.next.next;
            else ptr = ptr.next;
        }


        return head;
    }
}
