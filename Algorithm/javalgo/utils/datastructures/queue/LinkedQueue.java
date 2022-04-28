package datastructures.queue;

import java.util.NoSuchElementException;

public class LinkedQueue {
    class Node {
        int data;
        Node next;

        public Node() {
            this(0);
        }

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        front = rear = new Node();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(int data) {
        Node newNode = new Node(data);
        rear.next = newNode;
        rear = newNode;
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node destory = front.next;
        int retValue = destory.data;
        front.next = front.next.next;
        destory = null;
        size--;

        if (isEmpty()) {
            front = rear;
        }

        return retValue;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return front.next.data;
    }

    public int peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }

    public int size() {
        return size;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = front.next;
        builder.append("[");
        while (cur != null) {
            builder.append(cur.data).append(", ");
            cur = cur.next;
        }
        builder.replace(builder.length() - 2, builder.length(), "]");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        assert queue.isEmpty();

        queue.enqueue(1); /* 1 */
        queue.enqueue(2); /* 1 2 */
        queue.enqueue(3); /* 1 2 3 */
        System.out.println(queue); /* [1, 2, 3] */

        assert queue.size() == 3;
        assert queue.dequeue() == 1;
        assert queue.peekFront() == 2;
        assert queue.peekRear() == 3;

        queue.clear();
        assert queue.isEmpty();

        System.out.println(queue); /* [] */
    }
}
