package datastructures.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArrayList {
    
    private ArrayList<Integer> stack;

    public StackArrayList(){
        stack=new ArrayList<>();
    }

    public void push(int value){
        stack.add(value);
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.get(stack.size()-1);
    }

    public int size(){
        return stack.size();
    }
}
