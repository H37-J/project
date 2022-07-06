package datastructures.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LinkedListSort {

    Node mergetList(Node[] a, int N) {
        PriorityQueue<Node> min = new PriorityQueue<>(Comparator.comparingInt(x -> x.data));

        min.addAll(Arrays.asList(a).subList(0, N));

        Node head = min.poll();
        min.add(head.next);
        Node cur = head;

        while (!min.isEmpty()) {
            Node temp = min.poll();
            cur.next = temp;
            cur = temp;
            if (temp.next != null) {
                min.add(temp.next);
            }
        }
        return head;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int d) {
            this.data = d;
            next = null;
        }
    }
}
