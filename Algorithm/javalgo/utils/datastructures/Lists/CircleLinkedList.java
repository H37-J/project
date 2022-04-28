package datastructures.Lists;

public class CircleLinkedList<E> {
    
    private static class Node<E> {
        Node<E> next;
        E value;

        private Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head = null;
    private Node<E> tail = null;

    public CircleLinkedList(){
        head = new Node<E>(null, head);
        tail = head;
        size =0;
    }

    public int getSize(){
        return this.size;
    }

    public void append(E value){
        if(value == null){
            throw new NullPointerException("Cannot add null element to the list");
        }
        if(tail == null){
            tail = new Node<E>(value, head);
            head.next = tail;
        }else{
            tail.next = new Node<E>(value, head);
            tail = tail.next;
        }
        size++;
    }

    public String toString(){
        Node p = head.next;
        String s ="[";
        while(p != head){
            s += p.value;
            s +=" , ";
            p = p.next;
        }
        return s + "]";
    }

    public E remove(int pos) {
        if (pos > size || pos < 0) {
            // catching errors
            throw new IndexOutOfBoundsException("position cannot be greater than size or negative");
        }
        // we need to keep track of the element before the element we want to remove we can see why
        // bellow.
        Node<E> before = head;
        for (int i = 1; i <= pos; i++) {
            before = before.next;
        }
        Node<E> destroy = before.next;
        E saved = destroy.value;
        // assigning the next reference to the the element following the element we want to remove...
        // the last element will be assigned to the head.
        before.next = before.next.next;
        // scrubbing
        if (destroy == tail) {
            tail = before;
        }
        destroy = null;
        size--;
        return saved;
    }



}
