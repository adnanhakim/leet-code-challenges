package JulyChallenges;

import java.util.Stack;

/*
July 10

Question: Flatten a Multilevel Doubly Linked List
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
*/

class July10 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {

        Node ptr = head;
        Stack<Node> stack = new Stack<>();

        while (ptr != null) {
            if (ptr.child != null) {
                if (ptr.next != null)
                    stack.push(ptr.next);
                ptr.next = ptr.child;
                if (ptr.next != null)
                    ptr.next.prev = ptr;
                ptr.child = null;
            } else if (ptr.next == null && !stack.isEmpty()) {
                ptr.next = stack.pop();
                if (ptr.next != null)
                    ptr.next.prev = ptr;
            }
            ptr = ptr.next;
        }


        return head;
    }
}
