package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Top Amazon Questions
// tag: graph
public class CopyListWithRandomPointer {

    // HashMap which holds old nodes as keys and new nodes as its values.
    Map<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }

//    public Node copyRandomList(Node head) {
//        Node deepCopy = null;
//
//        if (head != null) {
//            List<Node> nodes = new ArrayList<>();
//            Node current = head;
//            deepCopy = new Node(current.val);
//            Node currentDeep = deepCopy;
//            nodes.add(current);
//            current = current.next;
//
//            while (current != null) {
//                currentDeep.next = new Node(current.val);
//                nodes.add(current);
//                current = current.next;
//                currentDeep = currentDeep.next;
//            }
//
//        }
//
//        return deepCopy;
//    }

    public static void main(String[] args) {
        CopyListWithRandomPointer test = new CopyListWithRandomPointer();

        // Example 1
        Node head = new Node(7, 0);
        head.next = new Node(13, 1);
        head.random = null;
        head.next.next = new Node(11, 2);
        head.next.random = head;
        head.next.next.next = new Node(10, 3);
        head.next.next.next.next = new Node(1, 4);
        head.next.next.next.random = head.next.next;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.next.random = head;
        System.out.println(head);
        Node result = test.copyRandomList(head);

        // Example 2
        head = new Node(1, 0);
        head.next = new Node(2, 1);
        head.random = head.next;
        head.next.next = null;
        head.next.random = head.next;
        System.out.println(head);
        result = test.copyRandomList(head);

        // Example 3
        head = new Node(3, 0);
        head.random = null;
        head.next = new Node(3, 1);
        head.next.random = head;
        head.next.next = new Node(3, 2);
        head.next.next.random = null;
        System.out.println(head);
        result = test.copyRandomList(head);

        // Example 4
        head = null;
        System.out.println(head);
        result = test.copyRandomList(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;
        int index;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
            index = -1;
        }

        public Node(int val, int index) {
            this.val = val;
            this.next = null;
            this.random = null;
            this.index = index;
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");

            Node current = this;
            while (current != null) {
                String s = current.random == null ? "null" : Integer.toString(current.random.index);
                sb.append("[" + current.val + ", " + s + "]");
                if (current.next != null) sb.append(", ");
                current = current.next;
            }

            sb.append("]");
            return sb.toString();
        }
    }

}
