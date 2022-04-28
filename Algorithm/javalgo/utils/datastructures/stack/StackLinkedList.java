package datastructures.stack;

import java.util.NoSuchElementException;

public class StackLinkedList {
    
}

class Node{
    public int data;
    public Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack{

    Node head;
    private int size;

    public LinkedListStack(){
        head = null;
        size = 0;
    }

    public boolean push(int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public int pop(){
        if(size == 0){
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }

        Node destory = head;
        head = head.next;
        int retValue = destory.data;
        destory = null;
        size--;
        return retValue;
    }

    public int peek(){
        if(size==0){
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }
        return head.data;
    }

    @Override
    public String toString(){
        Node cur = head;
        StringBuilder builder = new StringBuilder();
        while(cur != null){
            builder.append(cur.data).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length()-2,builder.length(),"").toString();
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return this.size;
    }
}