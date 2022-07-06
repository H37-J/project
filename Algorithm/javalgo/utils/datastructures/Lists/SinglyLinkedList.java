package datastructures.Lists;

import java.util.StringJoiner;

public class SinglyLinkedList {

    private Node head;

    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void insertHead(int x) {
        insertNth(x, 0);
    }

    public void insert(int data) {
        insertNth(data, size);
    }

    public void insertNth(int data, int position) {
        checkBound(position, 0, size);
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node cur = head;
        for (int i = 0; i < position - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
    }

    public void deleteHead() {
        deleteNth(0);
    }

    public void delete() {
        deleteNth(size - 1);
    }

    public void deleteNth(int position) {
        checkBound(position, 0, size - 1);
        if (position == 0) {
            Node destory = head;
            head = head.next;
            destory = null;
            size--;
            return;
        }
        Node cur = head;
        for (int i = 0; i < position - 1; i++) {
            cur = cur.next;
        }
        Node destory = cur.next;
        cur.next = cur.next.next;
        destory = null;
        size--;
    }

    public void swapNodes(int a, int b) {
        Node currentNode = head;
        Node temp = null;
        while (currentNode != null) {
            if (currentNode.next.value == a) {
                temp = currentNode.next;
            }
            if (currentNode.next.value == b) {
                currentNode.next = temp;
            }
            currentNode = currentNode.next;
        }
    }

    Node reverseList(Node node) {
        Node prev = null, cur = node, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node = prev;
        return node;
    }

    public void checkBound(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    public void clear() {
        Node cur = head;
        while (cur != null) {
            Node prev = cur;
            cur = cur.next;
            prev = null;
        }
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public int count() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public boolean search(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == key)
                return true;
            cur = cur.next;
        }
        return false;
    }

    public int getNth(int index) {
        checkBound(index, 0, size - 1);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        Node cur = head;
        while (cur != null) {
            joiner.add(cur.value + "");
            cur = cur.next;
        }
        return joiner.toString();
    }

}

class Node {
    int value;
    Node next;

    Node() {

    }

    Node(int value) {
        this(value, null);
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}