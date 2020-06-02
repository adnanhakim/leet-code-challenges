package JuneChallenges;

/*
June 2

Question: Delete Node in a Linked List
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/
*/

class June2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
