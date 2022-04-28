package datastructures.queue;

public class Deques<T> {
    
    class DequeNode<S> {
        S val;
        DequeNode<S> next = null;
        DequeNode<S> prev = null;
        DequeNode(S val){
            this.val = val;
        }
    }

    DequeNode<T> head = null;
    DequeNode<T> tail = null;
    int size = 0;

    public void addFirst(T val){
        DequeNode<T> newNode = new DequeNode<T>(val);
        
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T val){
        DequeNode<T> newNode = new DequeNode<T>(val);
        
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T pollFirst(){
        if(head == null) return null;
        
        T oldHeadVal = head.val;

        if(head == tail){
            head = null;
            tail = null;
        }else{
            head.next.prev = null;
            DequeNode<T> oldHead = head;
            head = head.next;

            oldHead.next = null;
        }
        size--;
        return oldHeadVal;
    }

    public T pollLast(){
        if(tail == null) return null;

        T oldTailVal = tail.val;
        
        if(head == tail){
            head = null;
            tail = null;
        }else{
            tail.prev.next = null;
            DequeNode<T> oldTail = tail;
            tail = tail.prev;

            oldTail.prev = null;
        }
        size--;
        return oldTailVal;
    }
}
